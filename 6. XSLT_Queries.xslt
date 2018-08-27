<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>What are the names of the customers using laptops?</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">cusName</th>
    </tr>
    <xsl:for-each select="library/Customer">
      <tr>
      <xsl:variable name="NameOfCust" select="cusName"/>
      <xsl:variable name="CustomerID" select="cusID"/>
    <xsl:variable name="deviceInfo" select="//library/Devices[devName='Laptop' and Status='In Use' and cusID=$CustomerID]"/>
      <xsl:if test="$deviceInfo/devName">
        <td><xsl:value-of select="cusName"/></td>
      </xsl:if>
      </tr>
      </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>What books are borrowed?</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th style="text-align:left">Title</th>
      </tr>
      <xsl:for-each select="library/Books">
      <tr>
      <xsl:variable name="borrowedStatus" select="bkStatus" />
      <xsl:variable name="bookStatus" select="//library/Books[bkStatus=$borrowedStatus]"/>
      <xsl:if test="$bookStatus/bkStatus='Borrowed'">
        <td><xsl:value-of select="Title"/></td>
      </xsl:if>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>What books have been issued in April?</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th style="text-align:left">Title</th>
      </tr>
      <xsl:for-each select="library/IssueStatus">
      <tr>
      <xsl:variable name="issuedDate" select="issueDate" />
      <xsl:variable name="issueDateInfo" select="//library/IssueStatus[issueDate=$issuedDate]"/>
      <xsl:if test="$issueDateInfo/issueDate='April'">
        <td><xsl:value-of select="bookTitle"/></td>
      </xsl:if>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>What is the name of the employee who updates return status of returned books or devices</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">empName</th>
    </tr>
    <xsl:for-each select="library/Employee">
      <tr>
      <xsl:variable name="NameOfEmp" select="empName"/>
      <xsl:variable name="EmployeeID" select="empID"/>
    <xsl:variable name="returnStatusInfo" select="//library/EmployeeUpdatesReturnStatus[empID=$EmployeeID]"/>
      <xsl:if test="$returnStatusInfo/empID">
        <td><xsl:value-of select="empName"/></td>
      </xsl:if>
      </tr>
      </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <h2>What books have been returned in April?</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th style="text-align:left">Title</th>
      </tr>
      <xsl:for-each select="library/ReturnStatus">
      <tr>
      <xsl:variable name="returnedDate" select="returnDate" />
      <xsl:variable name="returnDateInfo" select="//library/ReturnStatus[returnDate=$returnedDate]"/>
      <xsl:if test="$returnDateInfo/returnDate='April'">
        <td><xsl:value-of select="bkTitle"/></td>
      </xsl:if>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>