
<%@include file="init.jspf"%>


<%@page import="com.mpower.springcrud.service.BookLocalServiceUtil"%>
<%@page import="com.mpower.springcrud.model.Book"%>
<%-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %> --%>

<title>BookForm</title>

<portlet:actionURL  var="createAccountURL" name="saveBook"/>

<portlet:actionURL  var="searchURL" name="searchBooks"/>

<aui:form action="<%=createAccountURL.toString() %>" method="post" name="bookDetailForm" >
	<aui:fieldset label="Book Add Form " column="<%= true %>">
		<aui:col width="<%= 50 %>" >
		
		<aui:input  bean="${bookDetailDTO.bookDetailForm}"
			name="bookId" type="hidden" />
			
		<aui:input label="Book Name"  bean="${bookDetailDTO.bookDetailForm}"
			name="bookName" id="bookName" helpMessage="ENter Book Name">
			
			<aui:validator name="required" errorMessage="Book Name is required"/>			
			<aui:validator name="minLength">2</aui:validator>
			<aui:validator name="maxLength">70</aui:validator>
		</aui:input>
		<liferay-ui:error key="name-is-required" message="Book Name is Required"></liferay-ui:error>  </p></p>
		
		<aui:input  label="Author" name="author" id="author"  bean="${bookDetailDTO.bookDetailForm}"
			helpMessage="ENter Book Author">
			
			<aui:validator name="required" errorMessage="Book author is required"/>			
			<aui:validator name="minLength">2</aui:validator>
			<aui:validator name="maxLength">70</aui:validator>
		
			
			</aui:input>
		<aui:input label="Price" name="price" bean="${bookDetailDTO.bookDetailForm}"
			helpMessage="ENter Book Author">
			
			<aui:validator name="required" errorMessage="Book author is required"/>			
			
			<aui:validator name="number"></aui:validator>
			</aui:input>
		<aui:select label="Book Type" name="bookType" 
		   		helpMessage="Select Book Type">
					<aui:option label="NOVEL" value="Novel" selected="<%=true %>" />
					<aui:option label="ACTION" value="Action" />
					<aui:option label="COMIC" value="Comic" />
					<aui:option label="CRIME" value="Crime" />
			</aui:select>
		
	
	 </aui:col>
	 </aui:fieldset>
	 <aui:button-row>
	<c:choose>
		<c:when test="${save}">
			
				<aui:button  type="submit" name="update" value="UpdateBook" ></aui:button>
				<aui:button  type="reset" name="Cancel" value="Cancel"></aui:button>
			
		</c:when>
		<c:otherwise>
							
				<aui:button  type="submit" name="add" value="AddBook" ></aui:button>				
				<aui:button type="reset" name="Cancel" value="Cancel"></aui:button>
			
		</c:otherwise>
	</c:choose>
	
	</aui:button-row>
	 
</aui:form>

