package org.gedcomx.record;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.NameStyle;
import org.gedcomx.types.NameType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.List;

public class Name extends Field {

  private QName type;
  private QName style;
  private List<NamePart> parts;

  public Name() {
  }

  @XmlAttribute
  @XmlQNameEnumRef(NameType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public NameType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), NameType.class);
  }

  public void setKnownType(NameType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  @XmlAttribute
  @XmlQNameEnumRef(NameStyle.class)
  public QName getStyle() {
    return style;
  }

  public void setStyle(QName style) {
    this.style = style;
  }

  @XmlTransient
  public NameStyle getKnownStyle() {
    return XmlQNameEnumUtil.fromQName(getType(), NameStyle.class);
  }

  public void setKnownStyle(NameStyle knownStyle) {
    this.style = XmlQNameEnumUtil.toQName(knownStyle);
  }

  @XmlElementWrapper(name = "parts")
  @XmlElement(name = "part")
  public List<NamePart> getParts() {
    return parts;
  }

  public void setParts(List<NamePart> parts) {
    this.parts = parts;
  }
}
