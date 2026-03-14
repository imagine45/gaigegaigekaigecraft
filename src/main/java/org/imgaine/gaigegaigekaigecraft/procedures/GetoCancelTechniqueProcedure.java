package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GetoCancelTechniqueProcedure {
   public GetoCancelTechniqueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double z_power = 0.0;
         double NUM1 = 0.0;
         String STR1 = "";
         String entity_name = "";
         if (entity.getPersistentData().m_128459_("friend_num") != 0.0 && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
            x_pos = 0.0;
            z_pos = 0.0;
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               Commands var10000 = entity.m_20194_().m_129892_();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               long var10002 = Math.round(x_pos);
               var10000.m_230957_(var10001, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
            }

            logic_a = false;
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(128.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && entityiterator.getPersistentData().m_128471_("CursedSpirit") && !(entityiterator instanceof Player) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker") && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_()) && entityiterator.getPersistentData().m_128459_("select") == 0.0) {
                  entity_name = entityiterator.m_5446_().getString();
                  logic_a = true;
                  NUM1 = 0.0;

                  for(int index0 = 0; index0 < 10000; ++index0) {
                     ++NUM1;
                     STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                     if (entity.getPersistentData().m_128461_(STR1 + "_name").equals(entityiterator.m_5446_().getString())) {
                        y_pos = entity.getPersistentData().m_128459_(STR1);
                        break;
                     }

                     if (entity.getPersistentData().m_128459_(STR1) == 0.0) {
                        y_pos = 64.0 + 64.0 * Math.random();
                        entity.getPersistentData().m_128347_(STR1, y_pos);
                        entity.getPersistentData().m_128359_(STR1 + "_name", entityiterator.m_5446_().getString());
                        break;
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123765_, entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5, entityiterator.m_20189_(), 20, 0.5, 0.5, 0.5, 0.0);
                  }

                  if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                  }

                  if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "execute in jujutsucraft:cursed_spirit_manipulation_dimension run tp @s " + x_pos + " " + y_pos + " " + z_pos);
                  }
                  break;
               }
            }

            if (logic_a) {
               entity.getPersistentData().m_128347_(STR1 + "_num", 0.0);
               if (world instanceof ServerLevel) {
                  ServerLevel _origLevel = (ServerLevel)world;
                  LevelAccessor var41 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                  if (var41 != null) {
                     Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : var41.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity_name.equals(entityiterator.m_5446_().getString()) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num")) {
                           entity.getPersistentData().m_128347_(STR1 + "_num", entity.getPersistentData().m_128459_(STR1 + "_num") + 1.0);
                        }
                     }
                  }

                  world = world;
               }

               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            } else {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         } else {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

         if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

      }
   }
}
