package com.example.biblioapp.domain.book;

import lombok.Getter;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDate;
import java.util.LinkedHashMap;

@Getter
public class BookDomain {
    private String bookId;

    private String bookName;

    private String isbn13;

    private String author;

    private String publisher;

    private LocalDate publicationDate;
    private String bookImgPath;

    public BookDomain(String bookId,
                      String bookName,
                      String isbn13,
                      String author,
                      String publisher,
                      LocalDate publicationDate,
                      String bookImgPath){
        this.bookId = bookId;
        this.bookName = bookName;
        this.isbn13 = isbn13;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.bookImgPath = bookImgPath;
    }

    public void checkForSaving (){
        if (bookName == null || bookName.isEmpty() || bookName.isBlank()){
            throw new IllegalArgumentException("本のタイトルは必須入力項目です");
        }
        if (isbn13 == null || isbn13.isEmpty() || isbn13.isBlank()){
            throw new IllegalArgumentException("ISBN13は必須入力項目です");
        }
        if (author == null || author.isEmpty() || author.isBlank()){
            throw new IllegalArgumentException("著者名は必須入力項目です");
        }
        if (publisher == null || publisher.isEmpty() || publisher.isBlank()){
            throw new IllegalArgumentException("出版社は必須入力項目です");
        }
        if (publicationDate == null) {
            throw new IllegalArgumentException("出版日は必須入力項目です");
        }
    }

    public void getBookImg() {
        final String endpoint = "https://api.openbd.jp/v1/get";
        final String url = endpoint + "?isbn=" + this.isbn13;

        RestTemplate rest = new RestTemplate();
        RequestEntity<Void> req = RequestEntity.get(url).build();
        ResponseEntity<Object[]> response = rest.exchange(req, Object[].class);

        Object[] responseBody = response.getBody();
        LinkedHashMap<String, Object> body = (LinkedHashMap<String, Object>) responseBody[0];
        if (body == null) {
            throw new IllegalArgumentException("対象のISBN13は存在しないか不正です");
        }
        var summary = (LinkedHashMap<String, Object>)body.get("summary");

        // 書影が取得できない場合はダミーURLを入れる
        var coverPath = summary.get("cover").toString();
        this.bookImgPath = (coverPath == null || coverPath.isEmpty())
                ? "https://placehold.jp/70x100.png"
                : coverPath;
    }
}
