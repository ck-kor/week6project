package com.sparta.week6project.dto.responseDto;

import com.sparta.week6project.model.Tag;
import com.sparta.week6project.repository.mapping.TagMapping;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostResponseDto {

    private String nickname;
    private String title;
    private String contents;
    private String imageUrl;
    private LocalDateTime modifiedAt;
    private Long heart;
    private Boolean isHeart;
//    private List<TagDto> tags;
    private List<TagMapping> tags;

}
