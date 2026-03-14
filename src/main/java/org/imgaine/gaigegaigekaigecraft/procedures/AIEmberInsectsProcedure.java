package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.FoxFireEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEmberInsectsProcedure {
   public AIEmberInsectsProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean reverse = false;
         boolean FoxFire = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double CNT6 = 0.0;
         double speed = 0.0;
         double start_time = 0.0;
         FoxFire = entity instanceof FoxFireEntity;
         start_time = FoxFire ? 15.0 : 10.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
         y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
         z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
               x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
               y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
               z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
               LivingEntity var10000;
               if (entity_a instanceof Mob) {
                  Mob _mobEnt = (Mob)entity_a;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt1") >= 40.0) {
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  Level var110 = ((Entity)var10000).m_9236_();
                  ClipContext var10001 = new ClipContext;
                  LivingEntity var10003;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10003 = _mobEnt.m_5448_();
                  } else {
                     var10003 = null;
                  }

                  Vec3 var137 = ((Entity)var10003).m_20299_(1.0F);
                  LivingEntity var10004;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10004 = _mobEnt.m_5448_();
                  } else {
                     var10004 = null;
                  }

                  Vec3 var150 = ((Entity)var10004).m_20299_(1.0F);
                  LivingEntity var10005;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10005 = _mobEnt.m_5448_();
                  } else {
                     var10005 = null;
                  }

                  var150 = var150.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
                  ClipContext.Block var174 = Block.OUTLINE;
                  ClipContext.Fluid var10006 = Fluid.NONE;
                  LivingEntity var10007;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var10001.<init>(var137, var150, var174, var10006, var10007);
                  x_pos = (double)var110.m_45547_(var10001).m_82425_().m_123341_();
                  LivingEntity var111;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var111 = _mobEnt.m_5448_();
                  } else {
                     var111 = null;
                  }

                  Level var112 = ((Entity)var111).m_9236_();
                  var10001 = new ClipContext;
                  LivingEntity var138;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var138 = _mobEnt.m_5448_();
                  } else {
                     var138 = null;
                  }

                  Vec3 var139 = ((Entity)var138).m_20299_(1.0F);
                  LivingEntity var152;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var152 = _mobEnt.m_5448_();
                  } else {
                     var152 = null;
                  }

                  Vec3 var153 = ((Entity)var152).m_20299_(1.0F);
                  LivingEntity var175;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var175 = _mobEnt.m_5448_();
                  } else {
                     var175 = null;
                  }

                  var153 = var153.m_82549_(((Entity)var175).m_20252_(1.0F).m_82490_(0.0));
                  ClipContext.Block var176 = Block.OUTLINE;
                  var10006 = Fluid.NONE;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var10001.<init>(var139, var153, var176, var10006, var10007);
                  y_pos = (double)var112.m_45547_(var10001).m_82425_().m_123342_();
                  LivingEntity var113;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var113 = _mobEnt.m_5448_();
                  } else {
                     var113 = null;
                  }

                  Level var114 = ((Entity)var113).m_9236_();
                  var10001 = new ClipContext;
                  LivingEntity var140;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var140 = _mobEnt.m_5448_();
                  } else {
                     var140 = null;
                  }

                  Vec3 var141 = ((Entity)var140).m_20299_(1.0F);
                  LivingEntity var155;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var155 = _mobEnt.m_5448_();
                  } else {
                     var155 = null;
                  }

                  Vec3 var156 = ((Entity)var155).m_20299_(1.0F);
                  LivingEntity var177;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var177 = _mobEnt.m_5448_();
                  } else {
                     var177 = null;
                  }

                  var156 = var156.m_82549_(((Entity)var177).m_20252_(1.0F).m_82490_(0.0));
                  ClipContext.Block var178 = Block.OUTLINE;
                  var10006 = Fluid.NONE;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10007 = _mobEnt.m_5448_();
                  } else {
                     var10007 = null;
                  }

                  var10001.<init>(var141, var156, var178, var10006, var10007);
                  z_pos = (double)var114.m_45547_(var10001).m_82425_().m_123343_();
               }

               if (entity.getPersistentData().m_128459_("cnt1") <= start_time) {
                  if (FoxFire && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y + (double)entity.m_20206_() * 0.5, z, 4, 0.1, 0.1, 0.1, 0.1);
                  }

                  entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20096_() ? 0.0 : entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  logic_b = var10000 instanceof LivingEntity;
                  if (logic_b) {
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     Level var117 = ((Entity)var10000).m_9236_();
                     ClipContext var128 = new ClipContext;
                     LivingEntity var142;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var142 = _mobEnt.m_5448_();
                     } else {
                        var142 = null;
                     }

                     Vec3 var143 = ((Entity)var142).m_20299_(1.0F);
                     LivingEntity var158;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var158 = _mobEnt.m_5448_();
                     } else {
                        var158 = null;
                     }

                     Vec3 var159 = ((Entity)var158).m_20299_(1.0F);
                     LivingEntity var179;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var179 = _mobEnt.m_5448_();
                     } else {
                        var179 = null;
                     }

                     var159 = var159.m_82549_(((Entity)var179).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var180 = Block.OUTLINE;
                     ClipContext.Fluid var195 = Fluid.NONE;
                     LivingEntity var205;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var205 = _mobEnt.m_5448_();
                     } else {
                        var205 = null;
                     }

                     var128.<init>(var143, var159, var180, var195, var205);
                     double var118 = Math.pow((double)(var117.m_45547_(var128).m_82425_().m_123341_() - entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_()), 2.0);
                     LivingEntity var129;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var129 = _mobEnt.m_5448_();
                     } else {
                        var129 = null;
                     }

                     Level var130 = ((Entity)var129).m_9236_();
                     ClipContext var10002 = new ClipContext;
                     LivingEntity var161;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var161 = _mobEnt.m_5448_();
                     } else {
                        var161 = null;
                     }

                     Vec3 var162 = ((Entity)var161).m_20299_(1.0F);
                     LivingEntity var181;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var181 = _mobEnt.m_5448_();
                     } else {
                        var181 = null;
                     }

                     Vec3 var182 = ((Entity)var181).m_20299_(1.0F);
                     LivingEntity var196;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var196 = _mobEnt.m_5448_();
                     } else {
                        var196 = null;
                     }

                     var182 = var182.m_82549_(((Entity)var196).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var197 = Block.OUTLINE;
                     ClipContext.Fluid var206 = Fluid.NONE;
                     LivingEntity var10008;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10008 = _mobEnt.m_5448_();
                     } else {
                        var10008 = null;
                     }

                     var10002.<init>(var162, var182, var197, var206, var10008);
                     var118 += Math.pow((double)(var130.m_45547_(var10002).m_82425_().m_123342_() - entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_()), 2.0);
                     LivingEntity var131;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var131 = _mobEnt.m_5448_();
                     } else {
                        var131 = null;
                     }

                     Level var132 = ((Entity)var131).m_9236_();
                     var10002 = new ClipContext;
                     LivingEntity var163;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var163 = _mobEnt.m_5448_();
                     } else {
                        var163 = null;
                     }

                     Vec3 var164 = ((Entity)var163).m_20299_(1.0F);
                     LivingEntity var184;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var184 = _mobEnt.m_5448_();
                     } else {
                        var184 = null;
                     }

                     Vec3 var185 = ((Entity)var184).m_20299_(1.0F);
                     LivingEntity var198;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var198 = _mobEnt.m_5448_();
                     } else {
                        var198 = null;
                     }

                     var185 = var185.m_82549_(((Entity)var198).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var199 = Block.OUTLINE;
                     var206 = Fluid.NONE;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10008 = _mobEnt.m_5448_();
                     } else {
                        var10008 = null;
                     }

                     var10002.<init>(var164, var185, var199, var206, var10008);
                     dis = Math.sqrt(var118 + Math.pow((double)(var132.m_45547_(var10002).m_82425_().m_123343_() - entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_()), 2.0));
                  } else {
                     dis = Math.sqrt(Math.pow((double)(entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_() - entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_()), 2.0) + Math.pow((double)(entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_() - entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_()), 2.0) + Math.pow((double)(entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_() - entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_()), 2.0));
                  }

                  if (!(dis < 32.0) && entity.getPersistentData().m_128459_("move") == 0.0) {
                     x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-8.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                     y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-8.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                     z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(-8.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity.m_146922_(entity.m_146908_() + 180.0F);
                     entity.m_146926_(entity.m_146909_() * -1.0F);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
                     y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                     z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
                  } else if (logic_b) {
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     Level var121 = ((Entity)var10000).m_9236_();
                     ClipContext var133 = new ClipContext;
                     LivingEntity var144;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var144 = _mobEnt.m_5448_();
                     } else {
                        var144 = null;
                     }

                     Vec3 var145 = ((Entity)var144).m_20299_(1.0F);
                     LivingEntity var165;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var165 = _mobEnt.m_5448_();
                     } else {
                        var165 = null;
                     }

                     Vec3 var166 = ((Entity)var165).m_20299_(1.0F);
                     LivingEntity var187;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var187 = _mobEnt.m_5448_();
                     } else {
                        var187 = null;
                     }

                     var166 = var166.m_82549_(((Entity)var187).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var188 = Block.OUTLINE;
                     ClipContext.Fluid var200 = Fluid.NONE;
                     LivingEntity var208;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var208 = _mobEnt.m_5448_();
                     } else {
                        var208 = null;
                     }

                     var133.<init>(var145, var166, var188, var200, var208);
                     x_pos = (double)var121.m_45547_(var133).m_82425_().m_123341_();
                     LivingEntity var122;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var122 = _mobEnt.m_5448_();
                     } else {
                        var122 = null;
                     }

                     Level var123 = ((Entity)var122).m_9236_();
                     var133 = new ClipContext;
                     LivingEntity var146;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var146 = _mobEnt.m_5448_();
                     } else {
                        var146 = null;
                     }

                     Vec3 var147 = ((Entity)var146).m_20299_(1.0F);
                     LivingEntity var168;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var168 = _mobEnt.m_5448_();
                     } else {
                        var168 = null;
                     }

                     Vec3 var169 = ((Entity)var168).m_20299_(1.0F);
                     LivingEntity var189;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var189 = _mobEnt.m_5448_();
                     } else {
                        var189 = null;
                     }

                     var169 = var169.m_82549_(((Entity)var189).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var190 = Block.OUTLINE;
                     var200 = Fluid.NONE;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var208 = _mobEnt.m_5448_();
                     } else {
                        var208 = null;
                     }

                     var133.<init>(var147, var169, var190, var200, var208);
                     y_pos = (double)var123.m_45547_(var133).m_82425_().m_123342_();
                     LivingEntity var124;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var124 = _mobEnt.m_5448_();
                     } else {
                        var124 = null;
                     }

                     Level var125 = ((Entity)var124).m_9236_();
                     var133 = new ClipContext;
                     LivingEntity var148;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var148 = _mobEnt.m_5448_();
                     } else {
                        var148 = null;
                     }

                     Vec3 var149 = ((Entity)var148).m_20299_(1.0F);
                     LivingEntity var171;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var171 = _mobEnt.m_5448_();
                     } else {
                        var171 = null;
                     }

                     Vec3 var172 = ((Entity)var171).m_20299_(1.0F);
                     LivingEntity var191;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var191 = _mobEnt.m_5448_();
                     } else {
                        var191 = null;
                     }

                     var172 = var172.m_82549_(((Entity)var191).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var192 = Block.OUTLINE;
                     var200 = Fluid.NONE;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var208 = _mobEnt.m_5448_();
                     } else {
                        var208 = null;
                     }

                     var133.<init>(var149, var172, var192, var200, var208);
                     z_pos = (double)var125.m_45547_(var133).m_82425_().m_123343_();
                  }
               }
            }
         }

         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") >= start_time) {
            entity.getPersistentData().m_128379_("canFly", true);
            GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
            if (FoxFire) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123745_, x, y + (double)entity.m_20206_() * 0.5, z, 1, 0.1, 0.1, 0.1, 0.1);
               }
            } else if (entity.getPersistentData().m_128459_("move") != 0.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123744_, x, y + (double)entity.m_20206_() * 0.5, z, 1, 0.1, 0.1, 0.1, 0.1);
            }

            if (entity.getPersistentData().m_128459_("cnt1") == start_time) {
               if (entity.getPersistentData().m_128459_("move") == 0.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                     }
                  }
               } else {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.25F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.25F, false);
                     }
                  }
               }

               if (!FoxFire && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y + (double)entity.m_20206_() * 0.5, z, 5, 0.1, 0.1, 0.1, 0.5);
               }

               x_power = entity.getPersistentData().m_128459_("x_power") * (1.0 + entity.getPersistentData().m_128459_("speed"));
               y_power = entity.getPersistentData().m_128459_("y_power") * (1.0 + entity.getPersistentData().m_128459_("speed"));
               z_power = entity.getPersistentData().m_128459_("z_power") * (1.0 + entity.getPersistentData().m_128459_("speed"));
            } else {
               if (FoxFire) {
                  speed = 0.075;
               } else {
                  speed = entity.getPersistentData().m_128459_("move") == 0.0 ? 0.125 : 0.05;
               }

               if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * (1.0 + entity.getPersistentData().m_128459_("speed"))) {
                  x_power = entity.m_20184_().m_7096_() - speed;
               } else {
                  x_power = entity.m_20184_().m_7096_() + speed;
               }

               if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * (1.0 + entity.getPersistentData().m_128459_("speed"))) {
                  y_power = entity.m_20184_().m_7098_() - speed;
               } else {
                  y_power = entity.m_20184_().m_7098_() + speed;
               }

               if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * (1.0 + entity.getPersistentData().m_128459_("speed"))) {
                  z_power = entity.m_20184_().m_7094_() - speed;
               } else {
                  z_power = entity.m_20184_().m_7094_() + speed;
               }
            }

            if (!entity.getPersistentData().m_128471_("Stop")) {
               entity.m_20256_(new Vec3(x_power, y_power, z_power));
               BulletDomainHit2Procedure.execute(world, entity);
               RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.m_20184_().m_7096_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.m_20184_().m_7098_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.m_20184_().m_7094_() * 10.0, entity);
            } else {
               entity.getPersistentData().m_128379_("Stop", false);
            }

            entity.getPersistentData().m_128347_("Damage", (15.0 + entity.getPersistentData().m_128459_("cnt1") * 0.01) * Math.max(CNT6, 0.75));
            entity.getPersistentData().m_128347_("Range", 2.5);
            entity.getPersistentData().m_128347_("knockback", FoxFire ? 0.1 : 1.0 * Math.max(CNT6, 0.75));
            entity.getPersistentData().m_128347_("effect", 7.0);
            RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_() * 0.5, z, entity);
         }

         dis = Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("x_power"), 2.0) + Math.pow(entity.getPersistentData().m_128459_("y_power"), 2.0) + Math.pow(entity.getPersistentData().m_128459_("z_power"), 2.0));
         if (dis < 0.01) {
            dis = 1.0;
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 80.0 || entity.getPersistentData().m_128459_("cnt1") > 50.0 && entity.getPersistentData().m_128459_("move") != 0.0 || !entity.m_6084_() || world.m_8055_(BlockPos.m_274561_(x + entity.getPersistentData().m_128459_("x_power") / dis, y + entity.getPersistentData().m_128459_("y_power") / dis, z + entity.getPersistentData().m_128459_("z_power") / dis)).m_60815_() && entity.getPersistentData().m_128459_("cnt1") > 10.0) {
            entity.getPersistentData().m_128347_("Damage", 15.0 * Math.max(CNT6, 0.75));
            entity.getPersistentData().m_128347_("Range", 5.0);
            entity.getPersistentData().m_128347_("knockback", FoxFire ? 0.1 : 1.0 * Math.max(CNT6, 0.75));
            RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_() * 0.5, z, entity);
            Effect7Procedure.execute(world, x, y + (double)entity.m_20206_() * 0.5, z, entity);
         }

      }
   }
}
