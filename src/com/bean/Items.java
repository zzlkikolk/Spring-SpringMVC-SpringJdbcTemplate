package com.bean;

import java.util.List;

public class Items {
    private Integer id;
    private String ItemName;
    private String Item;
    private String Achoice;
    private String Bchoice;
    private String Cchoice;
    private String rightKey;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }
    

	public String getAchoice() {
		return Achoice;
	}

	public void setAchoice(String achoice) {
		Achoice = achoice;
	}

	public String getBchoice() {
		return Bchoice;
	}

	public void setBchoice(String bchoice) {
		Bchoice = bchoice;
	}

	public String getCchoice() {
		return Cchoice;
	}

	public void setCchoice(String cchoice) {
		Cchoice = cchoice;
	}

	public String getRightKey() {
        return rightKey;
    }

    public void setRightKey(String rightKey) {
        this.rightKey = rightKey;
    }

	@Override
	public String toString() {
		return "Items [id=" + id + ", ItemName=" + ItemName + ", Item=" + Item + ", Achoice=" + Achoice + ", Bchoice="
				+ Bchoice + ", Cchoice=" + Cchoice + ", rightKey=" + rightKey + "]";
	}
    
    
}
