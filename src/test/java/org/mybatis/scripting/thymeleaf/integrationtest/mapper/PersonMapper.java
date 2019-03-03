/**
 *    Copyright 2018-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.scripting.thymeleaf.integrationtest.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.mybatis.scripting.thymeleaf.integrationtest.domain.Mail;
import org.mybatis.scripting.thymeleaf.integrationtest.domain.Person;

import java.util.List;

public interface PersonMapper {

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("sql/PersonMapper/insertByBulk.sql")
  void insertByBulk(List<Person> persons);

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("sql/PersonMapper/insertMailsByBulk.sql")
  void insertMailsByBulk(List<Person> persons);

  @Select("SELECT * FROM person_mails ORDER BY id")
  List<Mail> selectMails();

}