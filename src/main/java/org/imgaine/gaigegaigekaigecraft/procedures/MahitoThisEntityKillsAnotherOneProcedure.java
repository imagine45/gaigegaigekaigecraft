package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.TransfiguredHumanEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.ModList;

public class MahitoThisEntityKillsAnotherOneProcedure {
   public MahitoThisEntityKillsAnotherOneProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double size = 0.0;
         double NUM1 = 0.0;
         if (!entity.m_6084_() && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:human")))) {
            if (sourceentity.getPersistentData().m_128459_("friend_num") == 0.0) {
               sourceentity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_();
            z_pos = entity.m_20189_();
            size = 0.75 + Math.random();
            NUM1 = (double)Math.round(Math.ceil(Math.random() * 3.0));
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.TRANSFIGURED_HUMAN.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", sourceentity.m_20149_());
                  entityinstance.getPersistentData().m_128347_("friend_num", sourceentity.getPersistentData().m_128459_("friend_num"));
                  entityinstance.getPersistentData().m_128347_("friend_num_worker", sourceentity.getPersistentData().m_128459_("friend_num"));
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (ModList.get().isLoaded("pehkui")) {
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "scale set pehkui:height " + size + " @s");
                     }

                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "scale set pehkui:width " + size + " @s");
                     }
                  } else if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity26 = (LivingEntity)entityinstance;
                     if (_livingEntity26.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity26.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(size);
                     }
                  }

                  if (entityinstance instanceof TransfiguredHumanEntity) {
                     TransfiguredHumanEntity animatable = (TransfiguredHumanEntity)entityinstance;
                     animatable.setTexture("idle_transfiguration" + Math.round(NUM1) + "_skin");
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
