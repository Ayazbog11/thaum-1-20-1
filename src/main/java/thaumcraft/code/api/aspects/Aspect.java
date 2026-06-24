package thaumcraft.code.api.aspects;

import net.minecraft.resources.ResourceLocation;
import thaumcraft.code.Thaumcraft;

import java.util.LinkedHashMap;

public class Aspect {
    public static final LinkedHashMap<String, Aspect> aspects = new LinkedHashMap<>();

    // Primal Aspects
    public static final Aspect AER = new Aspect("aer", 0xffff7e, "a", 1);
    public static final Aspect TERRA = new Aspect("terra", 0x56c000, "2", 1);
    public static final Aspect IGNIS = new Aspect("ignis", 0xff5a01, "c", 1);
    public static final Aspect AQUA = new Aspect("aqua", 0x3cd4fc, "3", 1);
    public static final Aspect ORDO = new Aspect("ordo", 0xd5d4ec, "7", 1);
    public static final Aspect PERDITIO = new Aspect("perditio", 0x404040, "8", 1);

    private final String tag;
    private final Aspect[] components;
    private final int color;
    private final String chatcolor;
    private final ResourceLocation image;
    private final int blend;

    public Aspect(String tag, int color, Aspect[] components, ResourceLocation image, int blend) {
        this.tag = tag;
        this.components = components;
        this.color = color;
        this.chatcolor = "";
        this.image = image;
        this.blend = blend;
        aspects.put(tag, this);
    }

    public Aspect(String tag, int color, String chatcolor, int blend) {
        this.tag = tag;
        this.components = null;
        this.color = color;
        this.chatcolor = chatcolor;
        this.image = new ResourceLocation(Thaumcraft.MODID, "textures/aspects/" + tag.toLowerCase() + ".png");
        this.blend = blend;
        aspects.put(tag, this);
    }

    public String getTag() {
        return tag;
    }

    public int getColor() {
        return color;
    }

    public ResourceLocation getImage() {
        return image;
    }

    public boolean isPrimal() {
        return components == null || components.length != 2;
    }

    public Aspect[] getComponents() {
        return components;
    }

    public String getChatcolor() {
        return chatcolor;
    }

    public int getBlend() {
        return blend;
    }

    public static Aspect getAspect(String tag) {
        return aspects.get(tag);
    }
}
