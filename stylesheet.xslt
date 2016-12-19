<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Decathlon Competition</h2>
				<table>
					<tr>
						<th>Rank</th>
						<th>Score</th>
						<th>Participants</th>
					</tr>
					<xsl:for-each select="Ranking/Rank">
						<tr>
							<td>
								<xsl:value-of select="rankPlace" />
							</td>
							<td>
								<xsl:value-of select="points" />
							</td>
							<td>
								<xsl:for-each select="participantNames">
									<xsl:value-of select="."/><xsl:element name="br"/>
								</xsl:for-each>
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>