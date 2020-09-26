package com.chain.ugc.v1;


import com.chain.ugc.Content;

public class SensitiveWordFilter {
    // return true if content doesn't contain sensitive words.
    public boolean filter(Content content) {
        if (!filterSexyWord(content)) {
            return false;
        }

        if (!filterAdsWord(content)) {
            return false;
        }

        if (!filterPoliticalWord(content)) {
            return false;
        }

        return true;
    }

    private boolean filterSexyWord(Content content) {
        //....
        return true;
    }

    private boolean filterAdsWord(Content content) {
        //...
        return true;
    }

    private boolean filterPoliticalWord(Content content) {
        //...
        return true;
    }
}
