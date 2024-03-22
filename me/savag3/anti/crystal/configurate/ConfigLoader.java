package me.savag3.anti.crystal.configurate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.yaml.NodeStyle;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

public final class ConfigLoader {
  private ConfigLoader() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static <T> T load(Path path, Class<T> configInstance) {
    try {
      YamlConfigurationLoader loader = getLoader(path);
      if (!Files.exists(path, new java.nio.file.LinkOption[0])) {
        Files.createFile(path, (FileAttribute<?>[])new FileAttribute[0]);
        try {
          T instance = (T)configInstance.getDeclaredConstructors()[0].newInstance(new Object[0]);
          CommentedConfigurationNode commentedConfigurationNode = (CommentedConfigurationNode)loader.load();
          commentedConfigurationNode.set(configInstance, instance);
          loader.save((ConfigurationNode)commentedConfigurationNode);
          return instance;
        } catch (InstantiationException|IllegalAccessException e) {
          e.printStackTrace();
        } 
      } 
      ConfigurationNode node = loader.load();
      T t = (T)node.get(configInstance);
      loader.save(node);
      return t;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  private static YamlConfigurationLoader getLoader(Path path) {
    YamlConfigurationLoader.Builder builder = (YamlConfigurationLoader.Builder)((YamlConfigurationLoader.Builder)YamlConfigurationLoader.builder().indent(2).nodeStyle(NodeStyle.BLOCK).source(() -> Files.newBufferedReader(path, StandardCharsets.UTF_8))).sink(() -> Files.newBufferedWriter(path, StandardCharsets.UTF_8, new java.nio.file.OpenOption[0]));
    builder.defaultOptions();
    return builder.build();
  }
}


/* Location:              C:\Users\jonas\Desktop\AntiCPVP-1.0.jar!\me\savag3\anti\crystal\configurate\ConfigLoader.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */