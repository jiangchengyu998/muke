package com.chain.ugc.v2;

import com.chain.ugc.Content;

public class PoliticalWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFilter(Content content) {
        return false;
    }
}
