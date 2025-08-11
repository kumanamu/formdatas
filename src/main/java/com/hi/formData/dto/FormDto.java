package com.hi.formData.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {
    private String name;
    private int age;
    private boolean trueOrFalse;
    private List<String> hobbies;  // 다중 체크박스 용도
    private String language;// 결과담기 radio-button 결과담기
    private Day day;
    //요일을 담는 enum 타입 변수
}