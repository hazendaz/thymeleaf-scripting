/*
 *    Copyright 2018-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.scripting.thymeleaf;

import java.util.Optional;
import java.util.function.Consumer;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * The interface for customizing a default {@code TemplateEngine} instanced by the MyBatis Thymeleaf. <br>
 * If you want to customize a default {@code TemplateEngine}, you implements class of this interface and you need to
 * specify the 'customizer' property of mybatis-thymeleaf.properties. <br>
 * <br>
 * e.g.) Implementation class:
 *
 * <pre>
 * package com.example;
 *
 * // ...
 * public class MyTemplateEngineCustomizer implements TemplateEngineCustomizer {
 *   public void customize(TemplateEngine defaultTemplateEngine) {
 *     // ...
 *   }
 * }
 * </pre>
 *
 * <br>
 * e.g.) Configuration file (mybatis-thymeleaf.properties):
 *
 * <pre>
 * customizer = com.example.MyTemplateEngineCustomizer
 * </pre>
 *
 * @author Kazuki Shimizu
 *
 * @version 1.0.0
 */
@FunctionalInterface
public interface TemplateEngineCustomizer extends Consumer<TemplateEngine> {

  /**
   * {@inheritDoc}
   *
   * @see #customize(TemplateEngine)
   */
  @Override
  default void accept(TemplateEngine templateEngine) {
    customize(templateEngine);
  }

  /**
   * Customize a default {@code TemplateEngine} instanced by the MyBatis Thymeleaf.
   *
   * @param defaultTemplateEngine
   *          a default {@code TemplateEngine} instanced by the MyBatis Thymeleaf
   */
  void customize(TemplateEngine defaultTemplateEngine);

  /**
   * Utility method to extract a {@code ITemplateResolver} that implements specified type.
   *
   * @param templateEngine
   *          A target {@code TemplateEngine}
   * @param type
   *          A target type for extracting instance
   * @param <T>
   *          A type that implements the {@code ITemplateResolver}
   *
   * @return A {@code ITemplateResolver} instance that implements specified type
   */
  static <T extends ITemplateResolver> Optional<T> extractTemplateResolver(TemplateEngine templateEngine,
      Class<T> type) {
    return templateEngine.getTemplateResolvers().stream().filter(type::isInstance).map(type::cast).findFirst();
  }

  /**
   * Enum for providing builtin customizer instance.
   *
   * @since 1.0.0
   */
  enum BuiltIn implements TemplateEngineCustomizer {

    /**
     * Default instance.
     * <p>
     * This customizer instance do nothing.
     * </p>
     */
    DO_NOTHING {
      @Override
      public void customize(TemplateEngine defaultTemplateEngine) {
        // NOP
      }
    }

  }

}
