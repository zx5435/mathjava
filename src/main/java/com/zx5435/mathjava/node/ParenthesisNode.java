package com.zx5435.mathjava.node;

import com.google.gson.JsonObject;
import com.zx5435.mathjava.MathNode;
import com.zx5435.mathjava.MathResult;
import com.zx5435.mathjava.MathScope;
import com.zx5435.mathjava.node.base.BaseMathNode;

import java.util.List;

/**
 * @author admin
 */
public class ParenthesisNode extends BaseMathNode implements MathNode {

    public MathNode content;

    public ParenthesisNode(JsonObject raw, MathScope scope) {
        super(raw, scope);

        JsonObject o = raw.get("content").getAsJsonObject();
        content = load(o, this.getScope());
    }

    @Override
    public String genStr() {
        return "(" + this.content.genStr() + ")";
    }

    @Override
    public MathResult genVal() {
        return this.content.genVal();
    }

    @Override
    public List<MathResult> genExpr() {
        return null;
    }

}
