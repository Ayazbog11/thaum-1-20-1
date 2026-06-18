package thaumcraft.code.api.aspects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class AspectList implements Serializable {
    public LinkedHashMap<Aspect, Integer> aspects = new LinkedHashMap<>();

    public AspectList() {
    }

    public AspectList copy() {
        AspectList out = new AspectList();
        for (Aspect a : this.getAspects()) {
            out.add(a, this.getAmount(a));
        }
        return out;
    }

    public int size() {
        return aspects.size();
    }

    public void readFromNBT(net.minecraft.nbt.CompoundTag tag) {
        aspects.clear();
        net.minecraft.nbt.ListTag tlist = tag.getList("Aspects", 10);
        for (int j = 0; j < tlist.size(); j++) {
            net.minecraft.nbt.CompoundTag rs = tlist.getCompound(j);
            if (rs.contains("key")) {
                this.add(Aspect.getAspect(rs.getString("key")), rs.getInt("amount"));
            }
        }
    }

    public void writeToNBT(net.minecraft.nbt.CompoundTag tag) {
        net.minecraft.nbt.ListTag tlist = new net.minecraft.nbt.ListTag();
        tag.put("Aspects", tlist);
        for (Aspect aspect : this.getAspects()) {
            if (aspect != null) {
                net.minecraft.nbt.CompoundTag f = new net.minecraft.nbt.CompoundTag();
                f.putString("key", aspect.getTag());
                f.putInt("amount", this.getAmount(aspect));
                tlist.add(f);
            }
        }
    }

    public AspectList add(Aspect aspect, int amount) {
        if (aspect == null) return this;
        if (this.aspects.containsKey(aspect)) {
            int oldamount = this.aspects.get(aspect);
            amount += oldamount;
        }
        this.aspects.put(aspect, amount);
        return this;
    }

    public AspectList add(AspectList in) {
        if (in != null) {
            for (Aspect a : in.getAspects()) {
                this.add(a, in.getAmount(a));
            }
        }
        return this;
    }

    public boolean remove(Aspect aspect, int amount) {
        if (this.aspects.containsKey(aspect)) {
            int oldamount = this.aspects.get(aspect);
            oldamount -= amount;
            if (oldamount <= 0) {
                this.aspects.remove(aspect);
            } else {
                this.aspects.put(aspect, oldamount);
            }
            return true;
        }
        return false;
    }

    public boolean remove(AspectList in) {
        boolean ret = false;
        if (in != null) {
            for (Aspect a : in.getAspects()) {
                ret = this.remove(a, in.getAmount(a)) || ret;
            }
        }
        return ret;
    }

    public int getAmount(Aspect aspect) {
        return this.aspects.getOrDefault(aspect, 0);
    }

    public Aspect[] getAspects() {
        return this.aspects.keySet().toArray(new Aspect[0]);
    }
}
