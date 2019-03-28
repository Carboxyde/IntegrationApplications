using ChronoBibliotheque;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using Tobii.Interaction.Wpf;

namespace ChronoWPF
{
    /// <summary>
    /// Logique d'interaction pour MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        bool clockHasGaze = false;
        Task updateClock;
        Chronometre chronometre=null;

        public MainWindow()
        {
            InitializeComponent();

        }

        private void updateTime(object sender, HasGazeChangedRoutedEventArgs e)
        {
                if (e.HasGaze)
                {
                    clockHasGaze = true;
                    Action<object> action = (object obj) =>
                    {
                        while (clockHasGaze)
                        {
                            updateTimer();
                            System.Threading.Thread.Sleep(100);

                        }
                    };
                    updateClock = new Task(action, "update");
                    updateClock.Start();
                }
                else
                {
                    clockHasGaze = false;
                }
        }

        private void updateTimer()
        {
            Dispatcher.Invoke(() =>
            {
                if (chronometre != null)
                {
                    var temps = chronometre.getTime();
                    maTextBox.Text = "\n" + temps / 1000 + "." + temps % 1000;
                }
            });
        }

        private void startChrono(object sender, RoutedEventArgs e)
        {
            if (chronometre == null)
            {

                chronometre = new Chronometre();
            }
            else
            {
                updateTimer();
                chronometre = null;
            }
        }
    }
}
