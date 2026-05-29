package utils;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class AnimationManager {

    // اداة تطبيق التلاشي و الانبثاق
    public static void fade(Node node, double time, double startValue, double endValue, boolean autoreverse) {

        FadeTransition fade = new FadeTransition(Duration.seconds(time), node);
        node.setOpacity(startValue);
        fade.setFromValue(startValue);
        fade.setToValue(endValue);
        fade.setAutoReverse(autoreverse);
        fade.play();
    }

    // ❌ Shake
    public static void shake(Node node, double durationMill, double fromValue, double toValue, int cycle, boolean autoRev) {
        TranslateTransition shake = new TranslateTransition(Duration.millis(50), node);
        shake.setFromX(fromValue);
        shake.setToX(toValue);
        shake.setCycleCount(cycle);
        shake.setAutoReverse(autoRev);
        shake.play();
    }

    // 🔘 Hover على الزر
    public static void nodeHover(Node node) {
        node.setOnMouseEntered(e -> scale(node, 1.1));
        node.setOnMouseExited(e -> scale(node, 1));
    }

    public static void scale(Node node, double value) {
        ScaleTransition st = new ScaleTransition(Duration.millis(150), node);
        st.setToX(value);
        st.setToY(value);
        st.play();
    }

    // =========================================================
    // ✅ NEW ANIMATIONS METHODS
    // =========================================================

    // ✨ Smooth page entrance animation
    public static void pageEntrance(Node node) {
        node.setOpacity(0);
        node.setTranslateY(25);

        FadeTransition fade = new FadeTransition(Duration.millis(650), node);
        fade.setFromValue(0);
        fade.setToValue(1);

        TranslateTransition slide = new TranslateTransition(Duration.millis(650), node);
        slide.setFromY(25);
        slide.setToY(0);

        ParallelTransition animation = new ParallelTransition(fade, slide);
        animation.play();
    }

    // 🃏 Beautiful card hover animation
    public static void cardHover(Node node) {
        node.setOnMouseEntered(e -> {
            ScaleTransition scale = new ScaleTransition(Duration.millis(240), node);
            scale.setToX(1.04);
            scale.setToY(1.04);

            TranslateTransition move = new TranslateTransition(Duration.millis(180), node);
            move.setToY(-6);

            DropShadow shadow = new DropShadow();
            shadow.setRadius(28);
            shadow.setSpread(0.25);
            shadow.setColor(Color.rgb(37, 99, 235, 0.45));
            node.setEffect(shadow);

            new ParallelTransition(scale, move).play();
        });

        node.setOnMouseExited(e -> {
            ScaleTransition scale = new ScaleTransition(Duration.millis(180), node);
            scale.setToX(1);
            scale.setToY(1);

            TranslateTransition move = new TranslateTransition(Duration.millis(180), node);
            move.setToY(0);

            new ParallelTransition(scale, move).play();
            node.setEffect(null);
        });
    }

    // 🔴 Red glow hover for dangerous / add buttons
    public static void redButtonHover(Node node) {
        node.setOnMouseEntered(e -> {
            scale(node, 1.06);

            DropShadow shadow = new DropShadow();
            shadow.setRadius(22);
            shadow.setSpread(0.35);
            shadow.setColor(Color.rgb(220, 38, 38, 0.65));
            node.setEffect(shadow);
        });

        node.setOnMouseExited(e -> {
            smoothScale(node, 1,240);
            node.setEffect(null);
        });
    }

    // 🔵 Blue glow hover for navigation buttons
    public static void blueButtonHover(Node node) {
        node.setOnMouseEntered(e -> {
            smoothScale(node, 1.05,240);

            DropShadow shadow = new DropShadow();
            shadow.setRadius(20);
            shadow.setSpread(0.30);
            shadow.setColor(Color.rgb(37, 99, 235, 0.60));
            node.setEffect(shadow);
        });

        node.setOnMouseExited(e -> {
            smoothScale(node, 1,240);
            node.setEffect(null);
        });
    }
    // 🟢 Green glow hover for action/success buttons
    public static void greenButtonHover(Node node) {

        node.setOnMouseEntered(e -> {

            smoothScale(node, 1.05, 240);

            DropShadow shadow = new DropShadow();

            shadow.setRadius(28);

            shadow.setSpread(0.18);

            shadow.setOffsetY(2);

            shadow.setColor(
                    Color.rgb(116, 238, 21, 0.45)
            );

            node.setEffect(shadow);
        });

        node.setOnMouseExited(e -> {

            smoothScale(node, 1, 240);

            node.setEffect(null);
        });
    }

    // 🔎 Search bar focus animation
    public static void searchFocus(Node node) {
        node.setOnMouseEntered(e -> {
            DropShadow shadow = new DropShadow();
            shadow.setRadius(18);
            shadow.setSpread(0.20);
            shadow.setColor(Color.rgb(59, 130, 246, 0.45));
            node.setEffect(shadow);
        });

        node.setOnMouseExited(e -> node.setEffect(null));
    }

    // 🌊 Soft floating animation for cards
    public static void floating(Node node) {
        TranslateTransition floatAnim = new TranslateTransition(Duration.seconds(2.2), node);
        floatAnim.setFromY(0);
        floatAnim.setToY(-5);
        floatAnim.setCycleCount(Animation.INDEFINITE);
        floatAnim.setAutoReverse(true);
        floatAnim.play();
    }

    // ⚡ Click pulse animation
    public static void clickPulse(Node node) {
        ScaleTransition pulseUp = new ScaleTransition(Duration.millis(90), node);
        pulseUp.setToX(0.94);
        pulseUp.setToY(0.94);

        ScaleTransition pulseDown = new ScaleTransition(Duration.millis(120), node);
        pulseDown.setToX(1);
        pulseDown.setToY(1);

        SequentialTransition pulse = new SequentialTransition(pulseUp, pulseDown);
        pulse.play();
    }

    // 💡 Glow animation
    public static void glow(Node node) {
        Glow glow = new Glow(0.35);
        node.setEffect(glow);

        FadeTransition fade = new FadeTransition(Duration.millis(350), node);
        fade.setFromValue(0.85);
        fade.setToValue(1);
        fade.setAutoReverse(true);
        fade.setCycleCount(2);
        fade.play();
    }

    // 🚀 Slide from left animation
    public static void slideFromOnXaxis(Node node,int fromValue,int durationMS) {
        node.setOpacity(0);
        node.setTranslateX(fromValue);

        FadeTransition fade = new FadeTransition(Duration.millis(durationMS), node);
        fade.setToValue(1);

        TranslateTransition slide = new TranslateTransition(Duration.millis(500), node);
        slide.setToX(0);

        new ParallelTransition(fade, slide).play();
    }

    // 🎯 Apply beautiful animation to all dashboard cards
    public static void applyCardAnimations(Node... nodes) {
        for (Node node : nodes) {
            cardHover(node);
            floating(node);
        }
    }

    // 🎯 Apply hover animation to many buttons
    public static void applyButtonAnimations(Node... nodes) {
        for (Node node : nodes) {
            blueButtonHover(node);
        }
    }
    // 🎬 Smooth scaling animation
    public static void smoothScale(Node node, double value, double duration) {

        ScaleTransition st = new ScaleTransition(Duration.millis(duration), node);

        st.setToX(value);
        st.setToY(value);

        st.setInterpolator(Interpolator.EASE_BOTH);

        st.play();
    }
}