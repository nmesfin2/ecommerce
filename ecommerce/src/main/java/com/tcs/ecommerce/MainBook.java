package com.tcs.ecommerce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.ecommerce.config.DBConfig;
import com.tcs.ecommerce.model.Book;
import com.tcs.ecommerce.model.Page;
import com.tcs.ecommerce.repository.BookRepository;
import com.tcs.ecommerce.repository.PageRepository;

public class MainBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		BookRepository bookRepository = context.getBean(BookRepository.class);
		PageRepository pageRepository = context.getBean(PageRepository.class);

		Book book = new Book(0, "Java Book", "James", "Java001", null);
		bookRepository.save(book);
		
		pageRepository.save(new Page(20, 1, "Introduction", "intro", book));
		pageRepository.save(new Page(40, 1, "Introduction to java 8", "intro to java", book));
		pageRepository.save(new Page(234, 1, "Introduction to collection", "intro to collection", book));
		
		
		context.close();
		
	}

}
