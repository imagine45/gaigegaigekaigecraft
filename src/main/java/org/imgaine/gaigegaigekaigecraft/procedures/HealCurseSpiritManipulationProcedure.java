package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class HealCurseSpiritManipulationProcedure {
   public HealCurseSpiritManipulationProcedure() {
   }

   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.m_9236_(), event.player.m_20185_(), event.player.m_20186_(), event.player.m_20189_(), event.player);
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double heal_amount = 0.0;
         if (entity.m_6084_()) {
            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 18.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18.0) {
               entity.getPersistentData().m_128347_("cnt_cursed_spirit_manipulation", entity.getPersistentData().m_128459_("cnt_cursed_spirit_manipulation") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_cursed_spirit_manipulation") > 100.0) {
                  entity.getPersistentData().m_128347_("cnt_cursed_spirit_manipulation", 0.0);
                  if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                     label74: {
                        x_pos = 0.0;
                        z_pos = 0.0;
                        if (entity instanceof Player) {
                           Player _plr = (Player)entity;
                           if (_plr.m_150110_().f_35937_) {
                              heal_amount = 9999.0;
                              break label74;
                           }
                        }

                        heal_amount = 5.0;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _origLevel = (ServerLevel)world;
                        LevelAccessor _worldorig = world;
                        LevelAccessor var28 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                        if (var28 != null) {
                           Vec3 _center = new Vec3(0.0, 128.0, 0.0);

                           for(Entity entityiterator : var28.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(128.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                              if (!(entityiterator instanceof Player) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                                 float var10000;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10000 = _livEnt.m_21223_();
                                 } else {
                                    var10000 = -1.0F;
                                 }

                                 float var10001;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10001 = _livEnt.m_21233_();
                                 } else {
                                    var10001 = -1.0F;
                                 }

                                 if (var10000 < var10001 && entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       var10001 = _livEnt.m_21223_();
                                    } else {
                                       var10001 = -1.0F;
                                    }

                                    double var35 = (double)var10001 + heal_amount;
                                    double var10002;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       var10002 = (double)_livEnt.m_21233_();
                                    } else {
                                       var10002 = -1.0;
                                    }

                                    _entity.m_21153_((float)Math.min(var35, var10002));
                                 }
                              }
                           }
                        }

                        world = _worldorig;
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128471_("UpdateSkills")) {
               entity.getPersistentData().m_128379_("UpdateSkills", false);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
