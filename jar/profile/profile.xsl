<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="ISO_8859-1"/>

  <xsl:template name="newline">
    <xsl:text>&#xa;</xsl:text>
  </xsl:template>

  <xsl:template match="/">
    <xsl:apply-templates select="profile"/>
  </xsl:template>

  <xsl:template match="profile">
    <xsl:text>#generated by xsl for </xsl:text><xsl:value-of select="@name"/>
    <xsl:call-template name="newline"/>
    <xsl:apply-templates select="font"/>
    <xsl:apply-templates select="container"/>
    <xsl:apply-templates select="audio"/>
    <xsl:apply-templates select="video"/>
  </xsl:template>

  <xsl:template match="font">
    <xsl:text>subfont=</xsl:text><xsl:value-of select="subfont/file"/>
    <xsl:call-template name="newline"/>
    <xsl:text>subcp=</xsl:text><xsl:value-of select="subcp"/>
    <xsl:call-template name="newline"/>
  </xsl:template>

  <xsl:template match="audio">
    <xsl:text>channels=</xsl:text><xsl:value-of select="channels"/>
    <xsl:call-template name="newline"/>
    <xsl:text>srate=</xsl:text><xsl:value-of select="srate"/>
    <xsl:call-template name="newline"/>
    <xsl:call-template name="av-codec"/>
  </xsl:template>

  <xsl:template match="video">
    <xsl:call-template name="av-codec"/>
  </xsl:template>

  <xsl:template name="av-codec">
    <xsl:apply-templates select="codec/*"/>
  </xsl:template>

  <xsl:template match="faac">
    <xsl:text>oac=faac=yes</xsl:text>
    <xsl:call-template name="newline"/>
    <xsl:text>faacopts=</xsl:text>
    <xsl:for-each select="*">
      <xsl:apply-templates select="."/>
      <xsl:if test="not(position()=last())">
        <xsl:text>:</xsl:text>
      </xsl:if>
    </xsl:for-each>
    <xsl:call-template name="newline"/>
  </xsl:template>

  <xsl:template match="x264">
    <xsl:text>ovc=x264=yes</xsl:text>
    <xsl:call-template name="newline"/>
    <xsl:text>x264encopts=</xsl:text>
    <xsl:for-each select="*">
      <xsl:apply-templates select="."/>
      <xsl:if test="not(position()=last())">
        <xsl:text>:</xsl:text>
      </xsl:if>
    </xsl:for-each>
    <xsl:call-template name="newline"/>
  </xsl:template>


  <xsl:template match="container">
    <xsl:text>ofps=</xsl:text><xsl:value-of select="ofps"/>
    <xsl:call-template name="newline"/>
    <xsl:text>vf=scale=</xsl:text><xsl:value-of select="scale"/>
    <xsl:call-template name="newline"/>
    <xsl:call-template name="container-codec"/>
  </xsl:template>

  <xsl:template name="container-codec">
    <xsl:apply-templates select="codec/*"/>
  </xsl:template>

  <xsl:template match="lavf">
    <xsl:text>of=lavf=yes</xsl:text>
    <xsl:call-template name="newline"/>
    <xsl:text>lavfopts=format=</xsl:text><xsl:value-of select="format"/>
    <xsl:call-template name="newline"/>
  </xsl:template>

  <xsl:template match="mpeg">
    <xsl:text>mpeg=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="raw">
    <xsl:text>raw=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="object">
    <xsl:text>object=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="br">
    <xsl:text>br=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="cabac">
    <xsl:text>cabac=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="global_header">
    <xsl:text>global_header=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="bitrate">
    <xsl:text>bitrate=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="level_idc">
    <xsl:text>level_idc=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="vbv_bufsize">
    <xsl:text>vbv_bufsize=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="vbv_maxrate">
    <xsl:text>vbv_maxrate=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="frameref">
    <xsl:text>frameref=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="me">
    <xsl:text>me=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="threads">
    <xsl:text>threads=</xsl:text><xsl:value-of select="."/>
  </xsl:template>
  <xsl:template match="trellis">
    <xsl:text>trellis=</xsl:text><xsl:value-of select="."/>
  </xsl:template>

</xsl:stylesheet>
