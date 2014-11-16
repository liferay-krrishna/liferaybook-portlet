/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mpower.springcrud.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.mpower.springcrud.model.Book;

/**
 * The persistence interface for the Book System service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mpower
 * @see BookPersistenceImpl
 * @see BookUtil
 * @generated
 */
public interface BookPersistence extends BasePersistence<Book> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookUtil} to access the Book System persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the Book Systems where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Book Systems where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mpower.springcrud.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of Book Systems
	* @param end the upper bound of the range of Book Systems (not inclusive)
	* @return the range of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Book Systems where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mpower.springcrud.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of Book Systems
	* @param end the upper bound of the range of Book Systems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Book System in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Returns the first Book System in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Book System, or <code>null</code> if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Book System in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Returns the last Book System in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Book System, or <code>null</code> if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Book Systems before and after the current Book System in the ordered set where uuid = &#63;.
	*
	* @param bookId the primary key of the current Book System
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a Book System with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book[] findByUuid_PrevAndNext(
		long bookId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Removes all the Book Systems where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Book Systems where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Book System where uuid = &#63; and groupId = &#63; or throws a {@link com.mpower.springcrud.NoSuchBookException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Returns the Book System where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching Book System, or <code>null</code> if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Book System where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Book System, or <code>null</code> if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the Book System where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the Book System that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Returns the number of Book Systems where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Book Systems where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Book Systems where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mpower.springcrud.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of Book Systems
	* @param end the upper bound of the range of Book Systems (not inclusive)
	* @return the range of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Book Systems where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mpower.springcrud.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of Book Systems
	* @param end the upper bound of the range of Book Systems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Book System in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Returns the first Book System in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Book System, or <code>null</code> if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Book System in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Returns the last Book System in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Book System, or <code>null</code> if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Book Systems before and after the current Book System in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param bookId the primary key of the current Book System
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a Book System with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book[] findByUuid_C_PrevAndNext(
		long bookId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Removes all the Book Systems where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Book Systems where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Book Systems where bookName LIKE &#63;.
	*
	* @param bookName the book name
	* @return the matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findByBookName(
		java.lang.String bookName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Book Systems where bookName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mpower.springcrud.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookName the book name
	* @param start the lower bound of the range of Book Systems
	* @param end the upper bound of the range of Book Systems (not inclusive)
	* @return the range of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findByBookName(
		java.lang.String bookName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Book Systems where bookName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mpower.springcrud.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookName the book name
	* @param start the lower bound of the range of Book Systems
	* @param end the upper bound of the range of Book Systems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findByBookName(
		java.lang.String bookName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Book System in the ordered set where bookName LIKE &#63;.
	*
	* @param bookName the book name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book findByBookName_First(
		java.lang.String bookName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Returns the first Book System in the ordered set where bookName LIKE &#63;.
	*
	* @param bookName the book name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Book System, or <code>null</code> if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book fetchByBookName_First(
		java.lang.String bookName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Book System in the ordered set where bookName LIKE &#63;.
	*
	* @param bookName the book name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book findByBookName_Last(
		java.lang.String bookName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Returns the last Book System in the ordered set where bookName LIKE &#63;.
	*
	* @param bookName the book name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Book System, or <code>null</code> if a matching Book System could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book fetchByBookName_Last(
		java.lang.String bookName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Book Systems before and after the current Book System in the ordered set where bookName LIKE &#63;.
	*
	* @param bookId the primary key of the current Book System
	* @param bookName the book name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a Book System with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book[] findByBookName_PrevAndNext(
		long bookId, java.lang.String bookName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Removes all the Book Systems where bookName LIKE &#63; from the database.
	*
	* @param bookName the book name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBookName(java.lang.String bookName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Book Systems where bookName LIKE &#63;.
	*
	* @param bookName the book name
	* @return the number of matching Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public int countByBookName(java.lang.String bookName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the Book System in the entity cache if it is enabled.
	*
	* @param book the Book System
	*/
	public void cacheResult(com.mpower.springcrud.model.Book book);

	/**
	* Caches the Book Systems in the entity cache if it is enabled.
	*
	* @param books the Book Systems
	*/
	public void cacheResult(
		java.util.List<com.mpower.springcrud.model.Book> books);

	/**
	* Creates a new Book System with the primary key. Does not add the Book System to the database.
	*
	* @param bookId the primary key for the new Book System
	* @return the new Book System
	*/
	public com.mpower.springcrud.model.Book create(long bookId);

	/**
	* Removes the Book System with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the Book System
	* @return the Book System that was removed
	* @throws com.mpower.springcrud.NoSuchBookException if a Book System with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book remove(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	public com.mpower.springcrud.model.Book updateImpl(
		com.mpower.springcrud.model.Book book)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Book System with the primary key or throws a {@link com.mpower.springcrud.NoSuchBookException} if it could not be found.
	*
	* @param bookId the primary key of the Book System
	* @return the Book System
	* @throws com.mpower.springcrud.NoSuchBookException if a Book System with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book findByPrimaryKey(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.springcrud.NoSuchBookException;

	/**
	* Returns the Book System with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the Book System
	* @return the Book System, or <code>null</code> if a Book System with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.springcrud.model.Book fetchByPrimaryKey(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Book Systems.
	*
	* @return the Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Book Systems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mpower.springcrud.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Book Systems
	* @param end the upper bound of the range of Book Systems (not inclusive)
	* @return the range of Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Book Systems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mpower.springcrud.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Book Systems
	* @param end the upper bound of the range of Book Systems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.springcrud.model.Book> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Book Systems from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Book Systems.
	*
	* @return the number of Book Systems
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}