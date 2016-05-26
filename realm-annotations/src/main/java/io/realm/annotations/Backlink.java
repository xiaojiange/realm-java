/*
 * Copyright 2016 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for defining a bi-directional link from one class to another. This annotation can
 * only be added to a field of the type {@code RealmResults}. The backlink is maintained by Realm
 * and only work on managed objects. Backlinks can be queried just like normal references.
 **
 * Example:
 *
 * <pre>
 * {@code
 * public class Person extends RealmObject {
 *     public String name;
 *     public Dog dog; // Normal reference
 * }
 *
 * public class Dog extends RealmObject {
 *     public String name;
 *
 *     // Link back to all owners pointing to this Dog. Automatically maintained by Realm
 *     \@Backlink
 *     public RealmResults&lt;Person&gt; owners;
 * }
 *
 * // Find all Dogs with at least one owner named John
 * realm.where(Dog.class).equalTo("owners", "John").findAll();
 * }
 * </pre>
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface Backlink {
    /**
     * The list of fields in the parent object that should be considered when evaluating the
     * backlinks. If empty, all fields are included.
     */
    String[] value() default "";
}
