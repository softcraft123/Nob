package com.armmc.app.announcements;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/armmc/app/announcements/AnnouncementDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "announcement", "Lcom/armmc/app/announcements/Announcement;", "onDismiss", "Lkotlin/Function1;", "", "<init>", "(Landroid/content/Context;Lcom/armmc/app/announcements/Announcement;Lkotlin/jvm/functions/Function1;)V", "setupViews", "view", "Landroid/view/View;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: AnnouncementDialog.kt */
public final class AnnouncementDialog extends Dialog {
    private final Announcement announcement;
    private final Function1<Announcement, Unit> onDismiss;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* compiled from: AnnouncementDialog.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.armmc.app.announcements.Announcement$AnnouncementType[] r0 = com.armmc.app.announcements.Announcement.AnnouncementType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.armmc.app.announcements.Announcement$AnnouncementType r1 = com.armmc.app.announcements.Announcement.AnnouncementType.INFO     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.armmc.app.announcements.Announcement$AnnouncementType r1 = com.armmc.app.announcements.Announcement.AnnouncementType.WARNING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.armmc.app.announcements.Announcement$AnnouncementType r1 = com.armmc.app.announcements.Announcement.AnnouncementType.CRITICAL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.armmc.app.announcements.Announcement$AnnouncementType r1 = com.armmc.app.announcements.Announcement.AnnouncementType.SUCCESS     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.announcements.AnnouncementDialog.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnouncementDialog(Context context, Announcement announcement2, Function1<? super Announcement, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(announcement2, "announcement");
        Intrinsics.checkNotNullParameter(function1, "onDismiss");
        this.announcement = announcement2;
        this.onDismiss = function1;
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_announcement, (ViewGroup) null);
        setContentView(inflate);
        Intrinsics.checkNotNull(inflate);
        setupViews(inflate);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        setOnDismissListener(new AnnouncementDialog$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(AnnouncementDialog announcementDialog, DialogInterface dialogInterface) {
        announcementDialog.onDismiss.invoke(announcementDialog.announcement);
    }

    private final void setupViews(View view) {
        Pair pair;
        ImageView imageView = (ImageView) view.findViewById(R.id.announcement_icon);
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.announcement_dismiss_button);
        CardView cardView = (CardView) view.findViewById(R.id.announcement_card);
        View findViewById = view.findViewById(R.id.announcement_header_bar);
        ((TextView) view.findViewById(R.id.announcement_title)).setText(this.announcement.getTitle());
        ((TextView) view.findViewById(R.id.announcement_message)).setText(this.announcement.getMessage());
        int i = WhenMappings.$EnumSwitchMapping$0[this.announcement.getType().ordinal()];
        if (i == 1) {
            pair = new Pair(Integer.valueOf(R.drawable.ic_info), Integer.valueOf(ContextCompat.getColor(getContext(), R.color.primary)));
        } else if (i == 2) {
            pair = new Pair(Integer.valueOf(R.drawable.ic_warning), Integer.valueOf(ContextCompat.getColor(getContext(), R.color.warning_accent)));
        } else if (i == 3) {
            pair = new Pair(Integer.valueOf(R.drawable.ic_error), Integer.valueOf(ContextCompat.getColor(getContext(), R.color.danger_light)));
        } else if (i == 4) {
            pair = new Pair(Integer.valueOf(R.drawable.ic_check_circle), Integer.valueOf(ContextCompat.getColor(getContext(), R.color.status_green)));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        imageView.setImageResource(intValue);
        imageView.setColorFilter(intValue2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(intValue2);
        gradientDrawable.setCornerRadii(new float[]{16.0f, 16.0f, 16.0f, 16.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        findViewById.setBackground(gradientDrawable);
        materialButton.setOnClickListener(new AnnouncementDialog$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void setupViews$lambda$1(AnnouncementDialog announcementDialog, View view) {
        announcementDialog.dismiss();
    }
}
