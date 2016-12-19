package com.homework.file.write;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Viktoras Kisielis
 */
@XmlRootElement(name = "Ranking")
public class RankingListWrapper<T> {
    protected List<T> list;

    public RankingListWrapper() {
    }

    public RankingListWrapper(List<T> list) {
        this.list = list;
    }

    @XmlElement(name = "Rank")
    public List<T> getList() {
        return list;
    }
}
