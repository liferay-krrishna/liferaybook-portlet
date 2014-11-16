 <%@ include file="init.jspf" %>

<%@page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@page import="com.mpower.springcrud.service.BookLocalServiceUtil"%>
<%@page import="com.mpower.springcrud.model.Book"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>

<div>
<h3> <liferay-ui:message key="Search Books" /> </h3>
<%
	List<Book> booksList =new ArrayList<Book>();
	
	booksList= (List<Book>)renderRequest.getAttribute("bookList");
	String portletId=PortalUtil.getPortletId(request);
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter(ActionRequest.ACTION_NAME, "searchPage");
	/* iteratorURL.setPortletId(portletId);
    iteratorURL.setWindowState(WindowState.NORMAL.toString()); */
    iteratorURL.setParameter("bookExt", (String)renderRequest.getAttribute("bookExt"));
    iteratorURL.setParameter("authorExt", (String)renderRequest.getAttribute("authorExt"));
    iteratorURL.setParameter("bookTypeExt", (String)renderRequest.getAttribute("bookTypeExt"));
	iteratorURL.setParameter("searchFileds", (String)renderRequest.getAttribute("searchFields"));
	//System.out.println(" iterratorurl ------- "+(String)renderRequest.getAttribute("searchFields"));

%>




<portlet:actionURL  var="searchURL" name="searchBooks" />

<aui:form action="<%=searchURL.toString() %>"  method="post" name="bookDetailForm"> 
	<aui:layout cssClass="searchField row-fluid">	
	<div class="span10">
		 <aui:column>		
			<aui:input name="bookName" id="bookName" type="text"  label="Book Name" ><%-- bean="${bookDetailDTO.bookDetailForm}" --%> 
			</aui:input></aui:column>	 <aui:column>	
			<aui:input name="author" id="author" type="text"  label="Author" ><%-- bean="${bookDetailDTO.bookDetailForm}"  --%> 
			</aui:input> </aui:column>	 <aui:column>	
			<aui:select label="Book Type" name="bookType" id="bookType"  inlineLabel="left">
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
	<aui:form  action=""  name="fmItem">
	<aui:input name="todoItems" type="hidden" />
	<liferay-ui:search-container delta="5" emptyResultsMessage="Sorry. There are no where about to display." 
			iteratorURL="<%=iteratorURL %>"  rowChecker="<%= new RowChecker(renderResponse) %>">
		<liferay-ui:search-container-results total="<%= booksList.size() %>" 
			results="<%= ListUtil.subList(booksList,searchContainer.getStart(),searchContainer.getEnd()) %>"/>
			<liferay-ui:search-container-row modelVar="book" className="Book"  keyProperty="bookId">
				 	<%-- <liferay-ui:search-container-column-text  name="Book Id"  property="bookId" > </liferay-ui:search-container-column-text> --%>
					<liferay-ui:search-container-column-text name="Book Name"  property="bookName" />
					<liferay-ui:search-container-column-text name="Author" property="author" />					
					<liferay-ui:search-container-column-text name="Price"  property="price" />
					<liferay-ui:search-container-column-text name="BookType" property="bookType" />
						<% 	
					PortletURL editURL = renderResponse.createActionURL();
					editURL.setParameter(ActionRequest.ACTION_NAME,"editBookDetails");
					editURL.setParameter("bookId", String.valueOf(book.getBookId()));
					PortletURL deleteURL = renderResponse.createActionURL();
					deleteURL.setParameter(ActionRequest.ACTION_NAME, "deleteBookDetails");
					deleteURL.setParameter("bookId", String.valueOf(book.getBookId()));
					
					%>
				<liferay-ui:search-container-column-text name="action" >
					<a href="<%=editURL.toString() %>"><liferay-ui:message key="edit" /></a> | <a href="<%=deleteURL.toString() %>" class="deleteButton" ><liferay-ui:message key="delete" /></a>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			  
	 <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" /> 
	</liferay-ui:search-container>
<%-- <aui:button  type="submit" name="update" value="UpdateBook" ></aui:button>
<aui:button href="<%= somethingToDoURL.toString() %>" namevalue="To Do Something"></aui:button> --%>
</div>
<aui:button onClick='<%= renderResponse.getNamespace() + "delete();" %>' value="Todo Something" />
</aui:form>
	<%-- <aui:script>
		Liferay.provide(
		window,
		'<portlet:namespace />delete',
		function() {
		var checkBoxValue = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		alert(checkBoxValue);
		},
		['liferay-util-list-fields']
		);
	</aui:script>

 --%>
<script>
Liferay.provide(
        window,
        '<portlet:namespace />delete',
         function() {
                    var cmd =   Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmItem,   '<portlet:namespace />allRowIds'); 
                    //alert(A.all('input[type=checkbox]'));
                    // alert(cmd);
                   
                    document.<portlet:namespace />fmItem.method = "post";                
                   // document.<portlet:namespace />fmItem.<portlet:namespace />todoItems.value = cmd;
                    alert(cmd);
                    submitForm(document.<portlet:namespace />fmItem, 
                    		'<portlet:actionURL   name="somethingToDo" />');
                   
                         },

          ['liferay-util-list-fields']

);
</script> 