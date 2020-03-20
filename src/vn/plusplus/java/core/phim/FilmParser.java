package vn.plusplus.java.core.phim;

import java.util.List;

public abstract class FilmParser<T> {
    public abstract T parserDetail(String url);
    public abstract List<String> parserListLink(String url);
}
