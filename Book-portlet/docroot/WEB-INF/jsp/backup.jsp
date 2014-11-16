 <%@ include file="init.jspf" %>


<%@page import="com.mpower.springcrud.service.BookLocalServiceUtil"%>
<%@page import="com.mpower.springcrud.model.Book"%>

<div>
<h3> <liferay-ui:message key="search" /> </h3>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/WEB-INF/jsp/book_search.jsp");

int count=0;

List<Book> booksList =new ArrayList<Book>();

booksList= (List<Book>)renderRequest.getAttribute("bookList");

%>


<portlet:actionURL  var="searchURL">
	<portlet:param name="action" value="searchBooks" />
</portlet:actionURL>

<aui:form action="<%=searchURL.toString() %>"> 
	<aui:layout cssClass="searchField row-fluid">	
	<div class="span10">
		 <aui:column>		
			<aui:input name="bookName" id="bookName" type="text"  label="Book Name" ><%-- bean="${bookDetailDTO.bookDetailForm}" --%> 
			</aui:input></aui:column>	 <aui:column>	
			<aui:input name="author" id="author" type="text"  label="Author" ><%-- bean="${bookDetailDTO.bookDetailForm}"  --%> 
			</aui:input> </aui:column>	 <aui:column>	
			<aui:select label="Book Type" name="bookType" id="bookType" >
			        <aui:option label="Select" value="none" selected="<%=true %>"  />
					<aui:option label="NOVEL" value="Novel" />
					<aui:option label="ACTION" value="Action" />
					<aui:option label="COMIC" value="Comic" />
					<aui:option label="CRIME" value="Crime" />
			</aui:select>
												
		</aui:column>
		 <aui:column>
			<aui:button type="submit" value="Search" />
		</aui:column>
	</div>	
	</aui:layout>
	
	
</aui:form>
	
	<liferay-ui:search-container delta="5" emptyResultsMessage="Sorry. There are no where about to display." 
			iteratorURL="<%=iteratorURL %>">
		<liferay-ui:search-container-results total="<%= booksList.size() %>" 
			results="<%= ListUtil.subList(booksList,searchContainer.getStart(),searchContainer.getEnd()) %>"/>
			<liferay-ui:search-container-row modelVar="book" className="Book">
				 	<liferay-ui:search-container-column-text name="bookId" property="bookId" > </liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="bookName" property="bookName" />
					<liferay-ui:search-container-column-text name="author" property="author" />					
					<liferay-ui:search-container-column-text name="price" property="price" />
					<liferay-ui:search-container-column-text name="bookType" property="bookType" />
						<% 	
					PortletURL editURL = renderResponse.createActionURL();
					editURL.setParameter("action","editBookDetails");
					editURL.setParameter("bookId", String.valueOf(book.getBookId()));
					PortletURL deleteURL = renderResponse.createActionURL();
					deleteURL.setParameter("bookId", String.valueOf(book.getBookId()));
					deleteURL.setParameter("action", "deleteBookDetails");
				%>
				<liferay-ui:search-container-column-text name="action" >
					<a href="<%=editURL.toString() %>"><liferay-ui:message key="edit" /></a> | <a href="<%=deleteURL.toString() %>" class="deleteButton" ><liferay-ui:message key="delete" /></a>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="<%= true %>"  />
	</liferay-ui:search-container>


</div>