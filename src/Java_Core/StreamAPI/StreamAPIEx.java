package Java_Core.StreamAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIEx {
    public static void main(String[] args) throws IOException {

        int[] arr = new int[]{-5, 2, -1, -87, -9432, 1, 2, 3, 5, 3, 2, 1, 45};
        long count = Arrays.stream(arr).filter(w -> w > 0).count(); //подсчет положительных элементов в стриме
        //System.out.println(count);
        //СОЗДАНИЕ СТРИМОВ - STREAM SOURCE
        //создание стрима №1 из коллекции
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a3", "a5");
        Stream<String> streamFromCollection = collection.stream();
        //создание стрима №2 из значений
        Stream<String> streamFromValues = Stream.of("str1", "str2", "str3");
        //создание стрима №3 из массива значений
        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        //создание стрима №4 из файла
        Stream<String> streamFromFiles = Files.lines(Paths.get("res/file.txt"));
        //создание стрима №5 из строки .chars()
        IntStream streamFromChars = "12345".chars();
        //создание стрима №6 из StringBuilder
        Stream.builder().add("a1").add("a2").add("a3").build();
        //создание стрима с помощью Stream.iterate:
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);

        //один и тот же стрим не меняется разными стейтментами. для проверрки кода раскомментируй строчку
        //.IllegalStateException: stream has already been operated upon or closed

        //КОНВЕЙЕРНЫЕ МЕТОДЫ
        //.filter()
        //System.out.println(Stream.of("a1", "a2", "a3").filter(a -> a.equals("a1")).count());
        //thesame filter with link
        //System.out.println(Stream.of("a1", "a2", "a3").filter("a1"::equals).count());

        //.skip() позволяет пропустить N первых элементов
        //System.out.println(streamFromCollection.skip(collection.size()-2).findFirst().orElse("1"));
        //distinct() возвращает коллекуию без дублей
        //System.out.println(streamFromCollection.distinct().collect(Collectors.toList()));
        //map() преобразует каждый элемент стрима
        //System.out.println(streamFromCollection.map((s) -> s + "_1").collect(Collectors.toList()));
        //peek()
        //streamFromCollection.peek((e) -> System.out.print(e)).collect(Collectors.toList());
        //limit() - позволяет ограничить выборку из стрима
        //System.out.println(streamFromCollection.limit(3).collect(Collectors.toList()));
        //sorted - позволяет сортировать значения либо в натуральном порядке либо задавая Comparator
        //System.out.println(streamFromCollection.sorted().collect(Collectors.toList()));
        //либо задавая Comparator
        //System.out.println(streamFromCollection.sorted((o1,o2)->-1).collect(Collectors.toList()));

        //ТЕРМИНАЛЬНЫЕ МЕТОДЫ(.count(),
        //findFirst() - возвращает первый элемент из стрима
        //System.out.println(String.valueOf(streamFromChars.findFirst().orElse(1)));

        //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Stream.html
//        boolean
//        allMatch(Predicate<? super T> predicate)
//        Возвращает, соответствуют ли все элементы этого потока указанному предикату.
//        boolean
//        anyMatch(Predicate<? super T> predicate)
//        Возвращает, соответствуют ли какие-либо элементы этого потока указанному предикату.
//                <R> R
//        collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
//        Выполняет операцию изменяемой редукции над элементами этого потока.
//<R,A> R
//        collect(Collector<? super T,A,R> collector)
//        Выполняет операцию изменяемой редукции над элементами этого потока с использованием Collector.
//        long
//        count()
//        Возвращает количество элементов в этом потоке.
//        Stream<T>
//        distinct()
//        Возвращает поток, состоящий из отдельных элементов (согласно Object.equals(Object)) этого потока.
//        default Stream<T>
//        dropWhile(Predicate<? super T> predicate)
//        Возвращает, если этот поток упорядочен, поток, состоящий из оставшихся элементов этого потока после отбрасывания самого длинного префикса элементов, соответствующих заданному предикату.
//        Stream<T>
//        filter(Predicate<? super T> predicate)
//        Возвращает поток, состоящий из элементов этого потока, соответствующих заданному предикату.
//        Optional<T>
//        findAny()
//        Возвращает Optionalописывающий некоторый элемент потока, или пустое значение, Optionalесли поток пуст.
//        Optional<T>
//        findFirst()
//        Возвращает Optionalописывающий первый элемент этого потока или пустое значение, Optionalесли поток пуст.
//<R> Stream<R>
//                flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
//        Возвращает поток, состоящий из результатов замены каждого элемента этого потока содержимым сопоставленного потока, полученного путем применения предоставленной функции сопоставления к каждому элементу.
//        DoubleStream
//        flatMapToDouble(Function<? super T,? extends DoubleStream> mapper)
//        Возвращает набор, DoubleStreamсостоящий из результатов замены каждого элемента этого потока содержимым сопоставленного потока, полученного путем применения предоставленной функции сопоставления к каждому элементу.
//        IntStream
//        flatMapToInt(Function<? super T,? extends IntStream> mapper)
//        Возвращает набор, IntStreamсостоящий из результатов замены каждого элемента этого потока содержимым сопоставленного потока, полученного путем применения предоставленной функции сопоставления к каждому элементу.
//        LongStream
//        flatMapToLong(Function<? super T,? extends LongStream> mapper)
//        Возвращает набор, LongStreamсостоящий из результатов замены каждого элемента этого потока содержимым сопоставленного потока, полученного путем применения предоставленной функции сопоставления к каждому элементу.
//        void
//        forEach(Consumer<? super T> action)
//        Выполняет действие для каждого элемента этого потока.
//        void
//        forEachOrdered(Consumer<? super T> action)
//        Выполняет действие для каждого элемента этого потока в порядке встреч потока, если поток имеет определенный порядок встреч.
//                Stream<T>
//        limit(long maxSize)
//        Возвращает поток, состоящий из элементов данного потока, усеченных так, чтобы их maxSizeдлина не превышала указанную.
//                <R> Stream<R>
//                map(Function<? super T,? extends R> mapper)
//        Возвращает поток, состоящий из результатов применения заданной функции к элементам этого потока.
//        default <R> Stream<R>
//                mapMulti(BiConsumer<? super T,? super Consumer<R>> mapper)
//        Возвращает поток, состоящий из результатов замены каждого элемента этого потока несколькими элементами, а именно нулем или более элементами.
//        default DoubleStream
//        mapMultiToDouble(BiConsumer<? super T,? super DoubleConsumer> mapper)
//        Возвращает набор DoubleStream, состоящий из результатов замены каждого элемента этого потока несколькими элементами, а именно нулем или более элементами.
//        default IntStream
//        mapMultiToInt(BiConsumer<? super T,? super IntConsumer> mapper)
//        Возвращает результат IntStream, состоящий из результатов замены каждого элемента этого потока несколькими элементами, а именно нулем или более элементами.
//        default LongStream
//        mapMultiToLong(BiConsumer<? super T,? super LongConsumer> mapper)
//        Возвращает набор LongStream, состоящий из результатов замены каждого элемента этого потока несколькими элементами, а именно нулем или более элементами.
//                DoubleStream
//        mapToDouble(ToDoubleFunction<? super T> mapper)
//        Возвращает набор DoubleStream, состоящий из результатов применения заданной функции к элементам этого потока.
//                IntStream
//        mapToInt(ToIntFunction<? super T> mapper)
//        Возвращает IntStreamнабор результатов применения заданной функции к элементам этого потока.
//        LongStream
//        mapToLong(ToLongFunction<? super T> mapper)
//        Возвращает набор LongStream, состоящий из результатов применения заданной функции к элементам этого потока.
//                Optional<T>
//        max(Comparator<? super T> comparator)
//        Возвращает максимальный элемент этого потока в соответствии с предоставленным Comparator.
//        Optional<T>
//        min(Comparator<? super T> comparator)
//        Возвращает минимальный элемент этого потока в соответствии с предоставленным Comparator.
//        boolean
//        noneMatch(Predicate<? super T> predicate)
//        Возвращает значение, соответствующее указанному предикату, если ни один элемент этого потока не соответствует указанному предикату.
//                Stream<T>
//        peek(Consumer<? super T> action)
//        Возвращает поток, состоящий из элементов этого потока, дополнительно выполняя указанное действие над каждым элементом по мере потребления элементов из результирующего потока.
//                Optional<T>
//        reduce(BinaryOperator<T> accumulator)
//        Выполняет редукцию элементов этого потока, используя ассоциативную функцию накопления, и возвращает Optionalописание редуцированного значения, если таковое имеется.
//        T
//        reduce(T identity, BinaryOperator<T> accumulator)
//        Выполняет сокращение элементов этого потока, используя предоставленное значение идентичности и ассоциативную функцию накопления, и возвращает сокращенное значение.
//                <U> U
//        reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
//        Выполняет редукцию элементов этого потока, используя предоставленные функции идентичности, накопления и объединения.
//        Stream<T>
//        skip(long n)
//        Возвращает поток, состоящий из оставшихся элементов данного потока после отбрасывания первых nэлементов потока.
//        Stream<T>
//        sorted()
//        Возвращает поток, состоящий из элементов этого потока, отсортированных в естественном порядке.
//                Stream<T>
//        sorted(Comparator<? super T> comparator)
//        Возвращает поток, состоящий из элементов данного потока, отсортированных в соответствии с предоставленным Comparator.
//        default Stream<T>
//        takeWhile(Predicate<? super T> predicate)
//        Возвращает, если этот поток упорядочен, поток, состоящий из самого длинного префикса элементов, взятых из этого потока, которые соответствуют заданному предикату.
//                Object[]
//        toArray()
//        Возвращает массив, содержащий элементы этого потока.
//                <A> A[]
//        toArray(IntFunction<A[]> generator)
//        Возвращает массив, содержащий элементы этого потока, используя предоставленную generatorфункцию для выделения возвращаемого массива, а также любые дополнительные массивы, которые могут потребоваться для секционированного выполнения или для изменения размера.
//        default List<T>
//        toList()
//        Накапливает элементы этого потока в List.




    }
}
