package org.gedcomx.record;

import org.gedcomx.types.CharacteristicType;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ryan Heaton
 */
@Test
public class TestCharacteristic {

  public void testCharacteristicTypes() throws Exception {

    Characteristic ch = new Characteristic();
    ch.setKnownType(CharacteristicType.Person.age);
    ch.setInterpreted("int");
    Persona persona = new Persona();
    persona.setCharacteristics(Arrays.asList(ch));

  }
}
