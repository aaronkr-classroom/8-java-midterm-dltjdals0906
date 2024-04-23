public class LibrarySystem {
	// 변수 정의
	private Book[] booklist;
	private static int bookCount = 0;
	private static final int NUM_BOOK = 10;
	
	// 생성자 정의
	public LibrarySystem() {
	    this.booklist = new Book[NUM_BOOK]; // 생성자
	}

	public void addBook(Book book) {
	    // 책 추가
	    // 도움을 위해 Cart.java의 insertBook(Book book)을 참조하세요
	    booklist[bookCount++] = book;
	}
	
	public void removeBook(String title) {
    	// `for` LibrarySystem의 모든 Book
		for ( int i = 0; i < bookCount; i++ ) {

      		// `if` 책 제목이 발견되면
			if ( booklist[i].getTitle().equals(title)) {
				
                // 찾은 책부터 시작하여 모든 요소를 왼쪽으로 이동합니다.
				for ( int j = i; j < bookCount - 1; j++ ) {
					booklist[j] = booklist[j+1];
				}
        
				// 마지막 요소를 null로 설정하고 bookCount를 줄입니다.
				booklist[--bookCount] = null;
				System.out.println("라이브러리에서 '" + title + "' 삭제했습니다.");
        
				return; // 책 제거 후 종료 방법
			}
		}
		// 찾을 수 없으면 메시지를 인쇄합니다.
		System.out.println("# 오류: '" + title + "' 못 찾았습니다!");
	}
	
	public void borrowBook(String title) {
	    // LibrarySystem의 모든 Book에 대해 반복합니다.
	    for (int i = 0; i < bookCount; i++) {
	        // 책 제목이 발견되면
	        if (booklist[i].getTitle().equals(title)) {
	            // 책이 있다면
	            // setAvailable을 false로 설정하고 메시지를 출력합니다.
	            booklist[i].setAvailable(false);
	            System.out.println("'" + title + "'이(가) 대출되었습니다.");
	            return; // 책을 찾았으므로 종료합니다.
	        }
	    }
	    // 책을 찾을 수 없으면 오류 메시지를 출력합니다.
	    System.out.println("오류: '" + title + "'을(를) 찾을 수 없습니다!");
	}

	
	public void returnBook(String title) {
	    // LibrarySystem의 모든 Book에 대해 반복합니다.
	    for (int i = 0; i < bookCount; i++) {
	        // 책 제목이 발견되면
	        if (booklist[i].getTitle().equals(title)) {
	            // 책이 있다면
	            // setAvailable을 true로 설정하고 메시지를 출력합니다.
	            booklist[i].setAvailable(true);
	            System.out.println("'" + title + "'이(가) 반납되었습니다.");
	            return; // 책을 찾았으므로 종료합니다.
	        }
	    }
	    // 책을 찾을 수 없으면 오류 메시지를 출력합니다.
	    System.out.println("# 오류: '" + title + "'을(를) 찾을 수 없습니다!");
	}

	
	public void displayAllBooks() {
	    // 책 목록 출력 (책이름, 저자, 출판년도, 대출가능여부 출력)
	    System.out.println("   책이름\t|   저자\t|   출판년도\t|   대출가능여부");
	    
	    
	    for (int i = 0; i < bookCount; i++) {
	    	Book book = booklist[i];
	        System.out.print(book.getTitle() + " | ");
	        System.out.print(book.getAuthor() + " | ");
	        System.out.print(book.getYear() + " | ");
	        System.out.println(book.isAvailable());
	        
	        
	    }
	}

	}
