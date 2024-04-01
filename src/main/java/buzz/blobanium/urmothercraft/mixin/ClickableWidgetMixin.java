package buzz.blobanium.urmothercraft.mixin;

import buzz.blobanium.urmothercraft.UrMotherCraft;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;

@Mixin(ClickableWidget.class)
public class ClickableWidgetMixin {
    private HashMap<Integer, Text> textHashMap = new HashMap<>();


    @Inject(at = @At("TAIL"), method = "getMessage", cancellable = true)
    private void message(CallbackInfoReturnable<Text> cir){
        if(!textHashMap.containsKey(cir.getReturnValue().getString().hashCode())){
            Text newText = Text.of(UrMotherCraft.getUrMotherText());
            textHashMap.put(cir.getReturnValue().getString().hashCode(), newText);
            cir.setReturnValue(newText);
        } else {
            cir.setReturnValue(textHashMap.get(cir.getReturnValue().getString().hashCode()));
        }
    }
}
