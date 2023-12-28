package com.rrw.templates.ghactionsjavagradlewebappforcontainers.domain.teams;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Team {
    private Integer id;
    private String node_id;
    private String slug;
    private String privacy;

    public boolean isSecret(){
        return "secret".equals(this.privacy);
    }

}