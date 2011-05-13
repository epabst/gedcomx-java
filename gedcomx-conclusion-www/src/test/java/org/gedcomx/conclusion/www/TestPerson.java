package org.gedcomx.conclusion.www;

import org.gedcomx.attribution.AttributionReference;
import org.gedcomx.conclusion.*;
import org.gedcomx.id.AlternateId;
import org.gedcomx.id.AlternateIdType;
import org.gedcomx.id.PersistentIdentifier;
import org.gedcomx.id.PersistentIdentifierType;
import org.gedcomx.source.AttributedSourceReference;
import org.gedcomx.source.SourceQualifier;
import org.gedcomx.source.SourceQualifierProperty;
import org.gedcomx.types.*;
import org.gedcomx.www.Link;
import org.gedcomx.www.Links;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.gedcomx.conclusion.www.SerializationUtil.processThroughJson;
import static org.gedcomx.conclusion.www.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPerson {

  /**
   * tests processing a WWW person through xml...
   */
  public void testWWWPersonXml() throws Exception {
    Person person = createTestPerson();
    person = processThroughXml(person);
    assertTestPerson(person);
  }

  /**
   * tests processing a WWW person through json...
   */
  public void testWWWPersonJson() throws Exception {
    Person person = createTestPerson();
    person = processThroughJson(person);
    assertTestPerson(person);
  }

  /**
   * tests serializing an instance of the www person to/from a "base" person via xml.
   */
  public void testWWWPersonToBasePersonViaXml() throws Exception {
    //todo: figure this out.
  }

  /**
   * tests serializing an instance of the www person to/from a "base" person via json.
   */
  public void testWWWPersonToBasePersonViaJson() throws Exception {
    //todo: figure this out.
  }


  private Person createTestPerson() {
    Person person = new Person();
    Gender gender = new Gender();
    gender.setLinks(new Links());
    gender.getLinks().setLinks(new ArrayList<Link>());
    Link genderLink = new Link();
    genderLink.setHref(URI.create("urn:gender"));
    gender.getLinks().getLinks().add(genderLink);
    gender.setType(GenderType.male);
    person.setGender(gender);

    person.setLinks(new Links());
    person.getLinks().setLinks(new ArrayList<Link>());
    Link personLink = new Link();
    personLink.setHref(URI.create("urn:person"));
    person.getLinks().getLinks().add(personLink);

    ArrayList<AlternateId> alternateIds = new ArrayList<AlternateId>();
    AlternateId alternateId = new AlternateId();
    alternateId.setKnownType(AlternateIdType.forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    person.setAlternateIds(alternateIds);

    List<org.gedcomx.conclusion.Characteristic> characteristics = new ArrayList<org.gedcomx.conclusion.Characteristic>();
    Characteristic characteristic = new Characteristic();
    characteristic.setLinks(new Links());
    characteristic.getLinks().setLinks(new ArrayList<Link>());
    Link characteristicLink = new Link();
    characteristicLink.setHref(URI.create("urn:characteristic"));
    characteristic.getLinks().getLinks().add(characteristicLink);
    characteristic.setAttribution(new AttributionReference());
    characteristic.getAttribution().setHref(URI.create("urn:characteristic-attribution"));
    characteristic.setDate(new Date());
    characteristic.getDate().setOriginal("original date");
    characteristic.getDate().setNormalized("normalized date");
    characteristic.getDate().setJulianDay(new JulianDayRange());
    characteristic.getDate().getJulianDay().setEarliest(1);
    characteristic.getDate().getJulianDay().setLatest(2);
    characteristic.setId("characteristic-id");
    characteristic.setKnownType(CharacteristicType.occupation);
    characteristic.setPlace(new Place());
    characteristic.getPlace().setOriginal("original place");
    characteristic.getPlace().setNormalized("normalized place");
    characteristic.getPlace().setGeoCode(new GeoCode());
    characteristic.getPlace().getGeoCode().setLatitude(1.2F);
    characteristic.getPlace().getGeoCode().setLongitude(3.4F);
    characteristic.setValue("characteristic-value");
    characteristics.add(characteristic);
    person.setCharacteristics(characteristics);

    List<org.gedcomx.conclusion.Event> events = new ArrayList<org.gedcomx.conclusion.Event>();
    Event event = new Event();
    event.setLinks(new Links());
    event.getLinks().setLinks(new ArrayList<Link>());
    Link eventLink = new Link();
    eventLink.setHref(URI.create("urn:event"));
    event.getLinks().getLinks().add(eventLink);
    event.setAttribution(new AttributionReference());
    event.getAttribution().setHref(URI.create("urn:event-attribution"));
    event.setDate(new Date());
    event.getDate().setOriginal("original date");
    event.getDate().setNormalized("normalized date");
    event.getDate().setJulianDay(new JulianDayRange());
    event.getDate().getJulianDay().setEarliest(1);
    event.getDate().getJulianDay().setLatest(2);
    event.setId("event-id");
    event.setKnownType(EventType.adoption);
    event.setPlace(new Place());
    event.getPlace().setOriginal("original place");
    event.getPlace().setNormalized("normalized place");
    event.getPlace().setGeoCode(new GeoCode());
    event.getPlace().getGeoCode().setLatitude(1.2F);
    event.getPlace().getGeoCode().setLongitude(3.4F);
    events.add(event);
    person.setEvents(events);

    List<org.gedcomx.conclusion.Name> names = new ArrayList<org.gedcomx.conclusion.Name>();
    Name name = new Name();
    name.setLinks(new Links());
    name.getLinks().setLinks(new ArrayList<Link>());
    Link nameLink = new Link();
    nameLink.setHref(URI.create("urn:name"));
    name.getLinks().getLinks().add(nameLink);
    ArrayList<NameForm> alternateForms = new ArrayList<NameForm>();
    NameForm nameForm = new NameForm();
    nameForm.setFullText("alternate name form");
    nameForm.setKnownScript(NameScript.chinese);
    ArrayList<NamePart> parts = new ArrayList<NamePart>();
    NamePart part = new NamePart();
    part.setKnownType(NamePartType.given);
    part.setText("alternate name part");
    parts.add(part);
    nameForm.setParts(parts);
    alternateForms.add(nameForm);
    name.setAlternateForms(alternateForms);
    name.setAttribution(new AttributionReference());
    name.getAttribution().setHref(URI.create("urn:name-attribution"));
    name.setId("name-id");
    name.setKnownStyle(NameStyle.spanish);
    name.setKnownType(NameType.formal);
    NameForm primaryForm = new NameForm();
    primaryForm.setFullText("primary form");
    primaryForm.setKnownScript(NameScript.chinese);
    primaryForm.setParts(new ArrayList<NamePart>());
    NamePart namePart = new NamePart();
    namePart.setKnownType(NamePartType.surname);
    namePart.setText("primary surname");
    primaryForm.getParts().add(namePart);
    name.setPrimaryForm(primaryForm);
    names.add(name);
    person.setNames(names);

    person.setPersistentId(new PersistentIdentifier());
    person.getPersistentId().setKnownType(PersistentIdentifierType.pal);
    person.getPersistentId().setValue(URI.create("pal"));

    person.setRelationships(new ArrayList<RelationshipReference>());
    RelationshipReference relationshipReference = new RelationshipReference();
    relationshipReference.setKnownRole(RelationshipRole.child);
    relationshipReference.setHref(URI.create("urn:relationship"));
    person.getRelationships().add(relationshipReference);

    ArrayList<AttributedSourceReference> sources = new ArrayList<AttributedSourceReference>();
    AttributedSourceReference attributedSourceReference = new AttributedSourceReference();
    attributedSourceReference.setAttribution(new AttributionReference());
    attributedSourceReference.getAttribution().setHref(URI.create("urn:source-reference-attribution"));
    attributedSourceReference.setHref(URI.create("urn:source-uri"));
    attributedSourceReference.setId("source-reference-id");
    attributedSourceReference.setKnownType(SourceReferenceType.source);
    ArrayList<SourceQualifier> qualifiers = new ArrayList<SourceQualifier>();
    SourceQualifier qualifier = new SourceQualifier();
    qualifier.setProperty(SourceQualifierProperty.x_pixels, "2");
    qualifiers.add(qualifier);
    attributedSourceReference.setQualifiers(qualifiers);
    sources.add(attributedSourceReference);
    person.setSources(sources);

    person.setId("pid");
    return person;
  }

  private void assertTestPerson(Person person) {
    Characteristic characteristic;
    Event event;
    Name name;
    RelationshipReference relationshipReference;
    AttributedSourceReference attributedSourceReference;
    assertEquals(GenderType.male, person.getGender().getType());
    assertTrue(person.getGender() instanceof Gender);
    assertEquals("urn:gender", ((Gender) person.getGender()).getLinks().getLinks().get(0).getHref().toString());

    assertEquals(1, person.getLinks().getLinks().size());
    assertEquals("urn:person", person.getLinks().getLinks().get(0).getHref().toString());

    assertEquals(1, person.getAlternateIds().size());
    assertEquals(AlternateIdType.forwarded, person.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", person.getAlternateIds().get(0).getValue());

    assertEquals(1, person.getCharacteristics().size());
    assertEquals(1, ((Characteristic) person.getCharacteristics().iterator().next()).getLinks().getLinks().size());
    characteristic = (Characteristic) person.getCharacteristics().iterator().next();
    assertEquals("urn:characteristic", characteristic.getLinks().getLinks().get(0).getHref().toString());
    assertEquals("urn:characteristic-attribution", characteristic.getAttribution().getHref().toString());
    assertEquals("original date", characteristic.getDate().getOriginal());
    assertEquals("normalized date", characteristic.getDate().getNormalized());
    assertEquals(1, characteristic.getDate().getJulianDay().getEarliest());
    assertEquals(2, characteristic.getDate().getJulianDay().getLatest());
    assertEquals("characteristic-id", characteristic.getId());
    assertEquals(CharacteristicType.occupation, characteristic.getKnownType());
    assertEquals("original place", characteristic.getPlace().getOriginal());
    assertEquals("normalized place", characteristic.getPlace().getNormalized());
    assertEquals(1.2F, characteristic.getPlace().getGeoCode().getLatitude());
    assertEquals(3.4F, characteristic.getPlace().getGeoCode().getLongitude());
    assertEquals("characteristic-value", characteristic.getValue());

    assertEquals(1, person.getEvents().size());
    assertEquals(1, ((Event) person.getEvents().iterator().next()).getLinks().getLinks().size());
    event = (Event) person.getEvents().iterator().next();
    assertEquals("urn:event", event.getLinks().getLinks().get(0).getHref().toString());
    assertEquals("urn:event-attribution", event.getAttribution().getHref().toString());
    assertEquals("original date", event.getDate().getOriginal());
    assertEquals("normalized date", event.getDate().getNormalized());
    assertEquals(1, event.getDate().getJulianDay().getEarliest());
    assertEquals(2, event.getDate().getJulianDay().getLatest());
    assertEquals("event-id", event.getId());
    assertEquals(EventType.adoption, event.getKnownType());
    assertEquals("original place", event.getPlace().getOriginal());
    assertEquals("normalized place", event.getPlace().getNormalized());
    assertEquals(1.2F, event.getPlace().getGeoCode().getLatitude());
    assertEquals(3.4F, event.getPlace().getGeoCode().getLongitude());

    assertEquals(1, person.getNames().size());
    assertEquals(1, ((Name) person.getNames().iterator().next()).getLinks().getLinks().size());
    name = (Name) person.getNames().iterator().next();
    assertEquals("urn:name", name.getLinks().getLinks().get(0).getHref().toString());
    name = (Name) person.getNames().iterator().next();
    assertEquals(1, name.getAlternateForms().size());
    assertEquals("alternate name form", name.getAlternateForms().get(0).getFullText());
    assertEquals(NameScript.chinese, name.getAlternateForms().get(0).getKnownScript());
    assertEquals(1, name.getAlternateForms().get(0).getParts().size());
    assertEquals("alternate name part", name.getAlternateForms().get(0).getParts().get(0).getText());
    assertEquals(NamePartType.given, name.getAlternateForms().get(0).getParts().get(0).getKnownType());
    assertEquals("urn:name-attribution", name.getAttribution().getHref().toString());
    assertEquals("name-id", name.getId());
    assertEquals(NameStyle.spanish, name.getKnownStyle());
    assertEquals(NameType.formal, name.getKnownType());
    assertEquals("primary form", name.getPrimaryForm().getFullText());
    assertEquals(NameScript.chinese, name.getPrimaryForm().getKnownScript());
    assertEquals(1, name.getPrimaryForm().getParts().size());
    assertEquals("primary surname", name.getPrimaryForm().getParts().get(0).getText());
    assertEquals(NamePartType.surname, name.getPrimaryForm().getParts().get(0).getKnownType());

    assertEquals("pal", person.getPersistentId().getValue().toString());
    assertEquals(PersistentIdentifierType.pal, person.getPersistentId().getKnownType());

    assertEquals(1, person.getRelationships().size());
    relationshipReference = person.getRelationships().iterator().next();
    assertEquals(RelationshipRole.child, relationshipReference.getKnownRole());
    assertEquals("urn:relationship", relationshipReference.getHref().toString());

    assertEquals(1, person.getSources().size());
    attributedSourceReference = person.getSources().iterator().next();
    assertEquals("urn:source-reference-attribution", attributedSourceReference.getAttribution().getHref().toString());
    assertEquals("urn:source-uri", attributedSourceReference.getHref().toString());
    assertEquals("source-reference-id", attributedSourceReference.getId());
    assertEquals(SourceReferenceType.source, attributedSourceReference.getKnownType());
    assertEquals(1, attributedSourceReference.getQualifiers().size());
    assertEquals(1, attributedSourceReference.getQualifiers().get(0).getProperties().size());
    //todo: figure out JSON deserialization of 'other attributes'
    //assertEquals("2", attributedSourceReference.getQualifiers().get(0).getProperty(SourceQualifierProperty.x_pixels));

    assertEquals("pid", person.getId());
  }

}
