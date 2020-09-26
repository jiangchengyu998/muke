package com.chain.ugc.v2;


import com.chain.ugc.Content;

public interface SensitiveWordFilter {
    boolean doFilter(Content content);
}
