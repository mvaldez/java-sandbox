package com.mvaldez.typeerasure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mvaldez
 */
public class TypeTest {
    public static void main(String[] args) {
    List<Feline> f = new ArrayList<>();
    f.add(new Feline());
    f.add(new Tiger());
    takeAnimal(f);

    List<Tiger> a = new ArrayList<>();
    a.add(new Tiger());
    takeAnimal(a);

    List<Object> o = new ArrayList<>();
    o.add(new Tiger());
    takeAnimal(o);

    }

    public static void takeAnimal(List<? super Tiger> animals) {
        // do stuff
    }

}
