package com.sandbox.functional;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TODO: JAVADOC ME
 *
 * @author {@link "mark.valdez@amd.com"}
 */
public class test {
   Set<Foo> fooSet = new LinkedHashSet<Foo>();

   public static void main(String[] args) {
      fooSet.add(new Foo("1", 1));

   }
}



