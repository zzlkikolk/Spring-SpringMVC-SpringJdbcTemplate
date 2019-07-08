package com.bean;

public class Score {
    private Integer id;
    private Integer Sid;
    private Integer Rid;
    private Integer Score;
    private String ItemName;
    public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return Sid;
    }

    public void setSid(Integer sid) {
        Sid = sid;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

	@Override
	public String toString() {
		return "Score [id=" + id + ", Sid=" + Sid + ", Rid=" + Rid + ", Score=" + Score + ", ItemName=" + ItemName
				+ "]";
	}

	public Score(Integer sid, Integer rid, Integer score, String itemName) {
		super();
		Sid = sid;
		Rid = rid;
		Score = score;
		ItemName = itemName;
	}

	public Score() {
		super();
	}

    
    
}
