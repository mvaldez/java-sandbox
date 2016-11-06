package com.sandbox.functional;


import com.google.common.base.MoreObjects;

public class Foo {
   final private String value;
   final private Integer integer;

   public Foo(String value, Integer integer) {
      this.value = value;
      this.integer = integer;
   }

    public String getValue() {
        return value;
    }

    public Integer getInteger() {
        return integer;
    }

    @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Foo foo = (Foo) o;

      if (!value.equals(foo.value)) return false;
      return integer.equals(foo.integer);

   }

   @Override
   public int hashCode() {
      int result = value.hashCode();
      result = 31 * result + integer.hashCode();
      return result;
   }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .add("integer", integer)
                .toString();
    }
}
