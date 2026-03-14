package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelticket_machine;
import org.imgaine.gaigegaigekaigecraft.entity.TicketGateEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TicketGateRenderer extends MobRenderer<TicketGateEntity, Modelticket_machine<TicketGateEntity>> {
   public TicketGateRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelticket_machine(context.m_174023_(Modelticket_machine.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(TicketGateEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/ticket_machine.png");
   }
}
