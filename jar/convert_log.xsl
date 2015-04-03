<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" version="4.0" indent="yes"
              doctype-public="-//W3C//DTD HTML 4.01//EN" />

  <xsl:template match="/">
    <xsl:element name="html">
      <xsl:element name="head">
        <xsl:element name="title">
          <xsl:text>meGUI convert log</xsl:text>
        </xsl:element>
      </xsl:element>

      <xsl:element name="link">
        <xsl:attribute name="rel">stylesheet</xsl:attribute>
        <xsl:attribute name="href">log.css</xsl:attribute>
        <xsl:attribute name="type">text/css</xsl:attribute>
      </xsl:element>

      <xsl:element name="body">
        <xsl:apply-templates select="log"/>
      </xsl:element>

    </xsl:element>
  </xsl:template>

  <xsl:template match="log">
    <xsl:apply-templates select="convert-log"/>
  </xsl:template>

  <xsl:template match="convert-log">
    <xsl:element name="table">
      <xsl:element name="caption">
        <xsl:text>meGUI convert log</xsl:text>
      </xsl:element>

      <xsl:element name="tr">
        <xsl:attribute name="class">head</xsl:attribute>
        <xsl:element name="th">
          <xsl:text>Name</xsl:text>
        </xsl:element>
        <xsl:element name="th">
          <xsl:text>Date</xsl:text>
        </xsl:element>
        <xsl:element name="th">
          <xsl:text>Stauts</xsl:text>
        </xsl:element>
      </xsl:element>

      <xsl:for-each select="job">
        <xsl:apply-templates select="."/>
      </xsl:for-each>
    </xsl:element>
  </xsl:template>

  <xsl:template match="job">
    <xsl:element name="tr">
      <xsl:attribute name="class">job</xsl:attribute>
      <xsl:apply-templates select="destination-file"/>
      <xsl:apply-templates select="start-time"/>
      <xsl:apply-templates select="status"/>
    </xsl:element>
  </xsl:template>

  <xsl:template match="destination-file">
    <xsl:element name="td">
      <xsl:attribute name="class">file-name</xsl:attribute>
      <!-- <xsl:value-of select="."/> -->
      <xsl:value-of select='replace(.,".*\\(.*).m4v","$1")'/>
    </xsl:element>
  </xsl:template>

  <xsl:template match="start-time">
    <xsl:element name="td">
      <xsl:attribute name="class">date</xsl:attribute>
      <xsl:value-of select='replace(.,"([0-9]{4}-[0-9]{2}-[0-9]{2}) .*","$1")'/>
    </xsl:element>
  </xsl:template>

  <xsl:template match="status">
    <xsl:element name="td">
      <xsl:attribute name="class">status</xsl:attribute>
      <xsl:value-of select="."/>
    </xsl:element>
  </xsl:template>

</xsl:stylesheet>
