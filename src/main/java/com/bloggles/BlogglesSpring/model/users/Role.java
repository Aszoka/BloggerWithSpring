package com.bloggles.BlogglesSpring.model.users;

import lombok.Getter;

public enum Role {

    admin("admin"),
    moderator("moderator"),
    user("user");

    @Getter
    final String label;

    private Role(String label) {
        this.label = label;
    }
}
