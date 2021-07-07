package com.umbrella.newsreader.util;

import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;

import org.xml.sax.XMLReader;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HtmlTagHandler implements Html.TagHandler {

    @Inject
    public HtmlTagHandler() {

    }

    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
        if (tag.equalsIgnoreCase("ins"))
            processUnderlineStrike(opening, output);
        else if (tag.equalsIgnoreCase("del"))
            processStrikeThrough(opening, output);
    }

    private void processUnderlineStrike(boolean opening, Editable output) {
        int len = output.length();
        if (opening) {
            output.setSpan(new UnderlineSpan(), len, len, Spannable.SPAN_MARK_MARK);
        } else {
            Object obj = getLast(output, UnderlineSpan.class);
            int where = output.getSpanStart(obj);

            output.removeSpan(obj);

            if (where != len) {
                output.setSpan(new UnderlineSpan(), where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    private void processStrikeThrough(boolean opening, Editable output) {
        int len = output.length();
        if (opening) {
            output.setSpan(new StrikethroughSpan(), len, len, Spannable.SPAN_MARK_MARK);
        } else {
            Object obj = getLast(output, StrikethroughSpan.class);
            int where = output.getSpanStart(obj);

            output.removeSpan(obj);

            if (where != len) {
                output.setSpan(new StrikethroughSpan(), where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    private Object getLast(Editable text, Class kind) {
        Object[] objs = text.getSpans(0, text.length(), kind);

        if (objs.length == 0) {
            return null;
        } else {
            for (int i = objs.length; i > 0; i--) {
                if (text.getSpanFlags(objs[i - 1]) == Spannable.SPAN_MARK_MARK) {
                    return objs[i - 1];
                }
            }
            return null;
        }
    }

}
