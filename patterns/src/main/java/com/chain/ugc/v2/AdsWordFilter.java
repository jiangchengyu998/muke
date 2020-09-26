package com.chain.ugc.v2;

import com.chain.ugc.Content;

public class AdsWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFilter(Content content) {
        return false;
    }
}
