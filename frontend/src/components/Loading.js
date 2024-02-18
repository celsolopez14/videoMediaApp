import React from 'react';
import { View, StyleSheet, Animated } from 'react-native';

const Loading = () => {
  return (
    <View style={styles.loader}>
      <Circle />
      <Circle delay={0.3} />
      <Circle delay={0.6} />
      <Circle delay={0.9} />
      <Circle delay={1.2} />
    </View>
  );
};

const Circle = ({ delay = 0 }) => {
  const animation = new Animated.Value(0);

  Animated.loop(
    Animated.sequence([
      Animated.timing(animation, {
        toValue: 1,
        duration: 1000,
        useNativeDriver: false,
      }),
      Animated.timing(animation, {
        toValue: 0,
        duration: 500,
        useNativeDriver: false,
      }),
    ]),
  ).start();

  const circleScale = animation.interpolate({
    inputRange: [0, 0.5, 1],
    outputRange: [1, 1.5, 1],
  });

  const dotScale = animation.interpolate({
    inputRange: [0, 0.5, 1],
    outputRange: [1, 0, 1],
  });

  const outlineScale = animation.interpolate({
    inputRange: [0, 1],
    outputRange: [0, 1],
  });

  return (
    <View style={[styles.circle, { animationDelay: delay * 1000 }]}>
      <Animated.View style={[styles.dot, { transform: [{ scale: dotScale }] }]} />
      <Animated.View
        style={[styles.outline, { transform: [{ scale: outlineScale }] }]}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  loader: {
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    color: 'hsl(0, 0%, 87%)',
    animation: '2s ease-in-out infinite',
  },
  circle: {
    position: 'relative',
    width: 20,
    height: 20,
    borderWidth: 2,
    borderRadius: 10,
    marginHorizontal: 10,
    backgroundColor: 'transparent',
  },
  dot: {
    position: 'absolute',
    transform: [{ translate: ['-50%', '-50%'] }],
    width: 16,
    height: 16,
    borderRadius: 8,
    backgroundColor: 'hsl(0, 0%, 87%)',
  },
  outline: {
    position: 'absolute',
    transform: [{ translate: ['-50%', '-50%'] }],
    width: 20,
    height: 20,
    borderRadius: 10,
    borderWidth: 2,
    borderColor: 'hsl(0, 0%, 87%)',
    opacity: 0,
  },
});

export default Loading;
