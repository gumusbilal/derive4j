/*
 * Copyright (c) 2019, Jean-Baptiste Giraudeau <jb@giraudeau.info>
 *
 * This file is part of "Derive4J - Processor API".
 *
 * "Derive4J - Processor API" is free software: you can redistribute it
 * and/or modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * "Derive4J - Processor API" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with "Derive4J - Processor API".  If not, see <http://www.gnu.org/licenses/>.
 */
package org.derive4j.processor.api;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import org.derive4j.Data;

@Data
public abstract class EitherModel {

  public interface Case<R> {
    R EitherModel(TypeElement typeElement, ExecutableElement leftConstructor, ExecutableElement rightConstructor);
  }

  EitherModel() {
  }

  public abstract <R> R match(Case<R> Case);

  public TypeElement typeElement() {
    return EitherModels.getTypeElement(this);
  }

  public ExecutableElement leftConstructor() {

    return EitherModels.getLeftConstructor(this);
  }

  public ExecutableElement rightConstructor() {

    return EitherModels.getRightConstructor(this);
  }
}
