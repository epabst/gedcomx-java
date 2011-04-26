package org.gedcomx.record;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.source.SourceReference;
import org.gedcomx.types.RecordType;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.List;

@XmlType (
  name = "baseRecord",
  propOrder = {"alternateIds", "collection", "personas", "events", "relationships", "characteristics", "sources"}
)
public class Record {

  private String id;
  private QName type;
  private List<AlternateId> alternateIds;
  private CollectionReference collection;
  private List<Persona> personas;
  private List<Event> events;
  private List<Relationship> relationships;
  private List<Characteristic> characteristics;
  private List<SourceReference> sources;

  public Record() {
  }

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlAttribute
  @XmlQNameEnumRef(RecordType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public RecordType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), RecordType.class);
  }

  public void setKnownType(RecordType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  @XmlElement(name="alternateId")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  public CollectionReference getCollection() {
    return collection;
  }

  public void setCollection(CollectionReference collection) {
    this.collection = collection;
  }

  @XmlElement(name = "person")
  public List<Persona> getPersonas() {
    return personas;
  }

  public void setPersonas(List<Persona> personas) {
    this.personas = personas;
  }

  @XmlElement(name = "event")
  public List<Event> getEvents() {
    return events;
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }

  @XmlElements({
    @XmlElement(name = "coupleRelationship", type = CoupleRelationship.class),
    @XmlElement(name = "parentChildRelationship", type = ParentChildRelationship.class),
    @XmlElement(name = "otherRelationship", type = OtherRelationship.class)
  })
  public List<Relationship> getRelationships() {
    return relationships;
  }

  public void setRelationships(List<Relationship> relationships) {
    this.relationships = relationships;
  }

  @XmlElement(name = "characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  @XmlElement(name = "source")
  public List<SourceReference> getSources() {
    return sources;
  }

  public void setSources(List<SourceReference> sources) {
    this.sources = sources;
  }
}
