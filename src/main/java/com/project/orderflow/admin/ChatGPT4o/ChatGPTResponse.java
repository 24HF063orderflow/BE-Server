package com.project.orderflow.admin.ChatGPT4o;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTResponse {
    @JsonProperty("choices")
    private List<Choice> choices;
}