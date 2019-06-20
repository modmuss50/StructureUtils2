package me.modmuss50.structureutils.mixin;

import net.minecraft.block.entity.StructureBlockBlockEntity;
import net.minecraft.server.network.packet.UpdateStructureBlockC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@SuppressWarnings("unused")
//Done in one mixin class because I can
@Mixin({StructureBlockBlockEntity.class, UpdateStructureBlockC2SPacket.class})
public class StructureSizeMixin {

	//Seems be a bit of a bug with the remapping so I put the intermediary names here
	@SuppressWarnings("InvalidMemberReference")
	@ModifyConstant(method = {"fromTag", "read", "method_11014", "method_11053"}, constant = {@Constant(intValue = 32), @Constant(intValue = -32)})
	private int getMaxSizePos(int value){
		return value > 0 ? 512 : -512;
	}

}
