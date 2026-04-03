package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GarudaBallEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GarudaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MoonDregsEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiHeterocephalusGlaberEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiPterosaurEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DieRikaProcedure {
   public DieRikaProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double timer = 0.0;
         double dis = 0.0;
         double old_cool = 0.0;
         if (entity.getPersistentData().getDouble("friend_num") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
               if (entity instanceof MoonDregsEntity) {
                  timer = 600.0;
               } else if (entity instanceof ShikigamiHeterocephalusGlaberEntity) {
                  timer = 600.0;
               } else if (entity instanceof ShikigamiPterosaurEntity) {
                  timer = 400.0;
               } else if (!(entity instanceof GarudaEntity) && !(entity instanceof GarudaBallEntity)) {
                  timer = entity.getPersistentData().getDouble("despawn_flag") == 2.0 ? Math.max(200.0, Math.min(entity.getPersistentData().getDouble("cnt_connect") * 1.0, 3600.0)) : 3600.0;
               } else {
                  timer = entity.getPersistentData().getDouble("despawn_flag") == 2.0 ? 200.0 : 400.0;
               }

               if (entity_a instanceof Player) {
                  Player _plr = (Player)entity_a;
                  if (_plr.getAbilities().instabuild) {
                     timer = 20.0;
                  }
               }

               old_cool = entity_a.getPersistentData().getDouble("COOLDOWN_TICKS");
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(timer), 0, false, false));
                  }
               }

               entity_a.getPersistentData().putDouble("COOLDOWN_TICKS", old_cool);
               if (entity instanceof RikaEntity && entity.getPersistentData().getDouble("despawn_flag") == 1.0 && entity_a instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity_a;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_curseis_lifted"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            }
         }

      }
   }
}
